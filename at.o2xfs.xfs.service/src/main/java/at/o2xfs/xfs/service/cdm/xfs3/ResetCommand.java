/*
 * Copyright (c) 2017, Andreas Fagschlunger. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package at.o2xfs.xfs.service.cdm.xfs3;

import java.util.Optional;

import at.o2xfs.log.Logger;
import at.o2xfs.log.LoggerFactory;
import at.o2xfs.win32.Pointer;
import at.o2xfs.xfs.WFSResult;
import at.o2xfs.xfs.cdm.CdmExecuteCommand;
import at.o2xfs.xfs.cdm.CdmMessage;
import at.o2xfs.xfs.cdm.v3_00.CashUnitError3;
import at.o2xfs.xfs.cdm.v3_00.ItemPosition3;
import at.o2xfs.xfs.cdm.v3_30.IncompleteRetract3_30;
import at.o2xfs.xfs.cdm.v3_30.ItemInfoSummary3_30;
import at.o2xfs.xfs.service.ReflectiveFactory;
import at.o2xfs.xfs.service.XfsServiceManager;
import at.o2xfs.xfs.service.cdm.CdmService;
import at.o2xfs.xfs.service.cmd.AbstractAsyncXfsCommand;
import at.o2xfs.xfs.service.cmd.XfsCommand;
import at.o2xfs.xfs.service.cmd.XfsExecuteCommand;
import at.o2xfs.xfs.service.cmd.event.SucessEvent;

public class ResetCommand extends AbstractAsyncXfsCommand<ResetListener, SucessEvent> {

	private static final Logger LOG = LoggerFactory.getLogger(ResetCommand.class);

	private final CdmService service;

	private final Optional<ItemPosition3> itemPosition;

	public ResetCommand(CdmService service) {
		this(service, null);
	}

	public ResetCommand(CdmService service, ItemPosition3 itemPosition) {
		this.service = service;
		this.itemPosition = Optional.ofNullable(itemPosition);
	}

	@Override
	protected XfsCommand createCommand() {
		return new XfsExecuteCommand<CdmExecuteCommand>(service, CdmExecuteCommand.RESET, itemPosition.orElse(null));
	}

	@Override
	public void fireIntermediateEvent(WFSResult wfsResult) {
		String method = "fireIntermediateEvent(WFSResult)";
		if (LOG.isDebugEnabled()) {
			LOG.debug(method, "wfsResult=" + wfsResult);
		}
		try {
			CdmMessage message = wfsResult.getEventID(CdmMessage.class);
			switch (message) {
				case EXEE_CASHUNITERROR:
					fireCashUnitError(ReflectiveFactory.create(service.getXfsVersion(), wfsResult.getResults(), CashUnitError3.class));
					break;
				case EXEE_INPUT_P6:
					fireInputP6();
					break;
				case EXEE_INFO_AVAILABLE:
					fireInfoAvailable(ReflectiveFactory.create(service.getXfsVersion(), wfsResult.getResults(), ItemInfoSummary3_30.class));
					break;
				case EXEE_INCOMPLETERETRACT:
					fireIncompleteRetract(ReflectiveFactory.create(service.getXfsVersion(), wfsResult.getResults(), IncompleteRetract3_30.class));
					break;
				default:
					throw new IllegalArgumentException("CdmMessage: " + message);
			}
		} finally {
			XfsServiceManager.getInstance().free(wfsResult);
		}
	}

	private void fireCashUnitError(CashUnitError3 cashUnitError) {
		String method = "fireCashUnitError(CashUnitError3)";
		if (LOG.isInfoEnabled()) {
			LOG.info(method, cashUnitError);
		}
		for (CashUnitErrorListener each : listeners) {
			each.onCashUnitError(cashUnitError);
		}
	}

	private void fireInputP6() {
		String method = "fireInputP6()";
		if (LOG.isInfoEnabled()) {
			LOG.info(method, "");
		}
		for (InputP6Listener each : listeners) {
			each.onInputP6();
		}
	}

	private void fireInfoAvailable(ItemInfoSummary3_30 itemInfoSummary) {
		String method = "fireInfoAvailable(ItemInfoSummary3_30)";
		if (LOG.isInfoEnabled()) {
			LOG.info(method, itemInfoSummary);
		}
		for (InfoAvailableListener each : listeners) {
			each.onInfoAvailable(itemInfoSummary);
		}
	}

	private void fireIncompleteRetract(IncompleteRetract3_30 incompleteRetract) {
		String method = "fireIncompleteRetract(IncompleteRetract3_30)";
		if (LOG.isInfoEnabled()) {
			LOG.info(method, incompleteRetract);
		}
		for (ResetListener each : listeners) {
			each.onIncompleteRetract(incompleteRetract);
		}
	}

	@Override
	protected SucessEvent createCompleteEvent(Pointer results) {
		return SucessEvent.build();
	}
}
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

package at.o2xfs.xfs.service.cim.cmd;

import java.util.List;

import at.o2xfs.xfs.cim.Reason;
import at.o2xfs.xfs.cim.v3_00.CashUnitError3;
import at.o2xfs.xfs.cim.v3_00.NoteNumberList3;
import at.o2xfs.xfs.cim.v3_00.P6Info3;
import at.o2xfs.xfs.cim.v3_10.ItemInfoSummary3_10;
import at.o2xfs.xfs.service.cmd.event.CommandListener;

public interface CashInListener extends CommandListener<CashInCompleteEvent> {

	public void onCashUnitError(CashUnitError3 cashUnitError);

	public void onInputRefuse(Reason reason);

	public void onNoteError(Reason reason);

	public void onSubCashIn(NoteNumberList3 noteNumberList3);

	public void onInputP6(List<P6Info3> p6Infos);

	public void onInfoAvailable(List<ItemInfoSummary3_10> itemInfoSummaries);

	public void onInsertItems();
}
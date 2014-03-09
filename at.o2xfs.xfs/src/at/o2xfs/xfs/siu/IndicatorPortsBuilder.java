/*
 * Copyright (c) 2014, Andreas Fagschlunger. All rights reserved.
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

package at.o2xfs.xfs.siu;

import java.util.Map;

import at.o2xfs.win32.WORDArray;

public final class IndicatorPortsBuilder extends AbstractPortsBuilder {

	protected IndicatorPortsBuilder(final WORDArray ports) {
		super(ports);
	}

	public void setOpenClosed(final SIUOpenClosedIndicatorPortState state) {
		setPort(SIUIndicator.OPENCLOSE, state);
	}

	public void setFasciaLight(final SIUFasciaLightPortState state) {
		setPort(SIUIndicator.FASCIALIGHT, state);
	}

	/**
	 * TODO: {@link SIUIndicator#AUDIO}
	 */

	public void setInternalHeating(final SIUInternalHeatingPortState state) {
		setPort(SIUIndicator.HEATING, state);
	}

	public void setConsumerDisplayBacklight(
			final SIUConsumerDisplayBacklightPortState state) {
		setPort(SIUIndicator.CONSUMER_DISPLAY_BACKLIGHT, state);
	}

	public void setTransactionIndicators(final Map<SIULamp, Boolean> indicators) {
		setPorts(SIUIndicator.TRANSINDICATOR, indicators);
	}

	public void setGeneralPurposeOutputPorts(final Map<SIULamp, Boolean> ports) {
		setPorts(SIUIndicator.GENERALOUTPUTPORT, ports);
	}
}
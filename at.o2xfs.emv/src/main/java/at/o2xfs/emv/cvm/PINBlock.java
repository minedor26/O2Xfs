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

package at.o2xfs.emv.cvm;

import at.o2xfs.common.Bytes;

public class PINBlock {

	private static final int FILLER = 0xF;

	private final byte[] pinBlock = new byte[8];

	private final String pin;

	private int pinIndex = 0;

	public PINBlock(String pin) {
		this.pin = pin;
		create();
	}

	private void create() {
		pinBlock[0] = 0x02 << 4;
		pinBlock[0] |= (byte) pin.length();
		for (int i = 1; i < pinBlock.length; i++) {
			pinBlock[i] = (byte) (nextInt() << 4);
			pinBlock[i] |= nextInt();
		}
	}

	private int nextInt() {
		if (pinIndex < pin.length()) {
			return toInt(pin.charAt(pinIndex++));
		}
		return FILLER;
	}

	private int toInt(char c) {
		return c - 48;
	}

	public byte[] getPINBlock() {
		return Bytes.copy(pinBlock);
	}
}
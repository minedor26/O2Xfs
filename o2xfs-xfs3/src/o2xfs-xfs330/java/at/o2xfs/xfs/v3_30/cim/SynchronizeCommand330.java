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

package at.o2xfs.xfs.v3_30.cim;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.win32.DWORD;
import at.o2xfs.win32.Pointer;
import at.o2xfs.win32.Struct;

public class SynchronizeCommand330 extends Struct {

	protected final DWORD command = new DWORD();
	protected final Pointer cmdData = new Pointer();

	protected SynchronizeCommand330() {
		add(command);
		add(cmdData);
	}

	public SynchronizeCommand330(Pointer p) {
		this();
		assignBuffer(p);
	}

	public long getCommand() {
		return command.get();
	}

	public Pointer getCmdData() {
		return cmdData;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getCommand()).append(getCmdData()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SynchronizeCommand330) {
			SynchronizeCommand330 synchronizeCommand330 = (SynchronizeCommand330) obj;
			return new EqualsBuilder().append(getCommand(), synchronizeCommand330.getCommand()).append(getCmdData(), synchronizeCommand330.getCmdData()).isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("command", getCommand()).append("cmdData", getCmdData()).toString();
	}
}

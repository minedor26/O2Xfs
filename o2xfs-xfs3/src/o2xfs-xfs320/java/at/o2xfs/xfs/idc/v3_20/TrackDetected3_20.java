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

package at.o2xfs.xfs.idc.v3_20;

import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.win32.Pointer;
import at.o2xfs.win32.Struct;
import at.o2xfs.xfs.idc.DataSource;
import at.o2xfs.xfs.win32.XfsWordBitmask;

public class TrackDetected3_20 extends Struct {

	protected final XfsWordBitmask<DataSource> tracks = new XfsWordBitmask<>(DataSource.class);

	protected TrackDetected3_20() {
		add(tracks);
	}

	public TrackDetected3_20(Pointer p) {
		this();
		assignBuffer(p);
	}

	public TrackDetected3_20(TrackDetected3_20 copy) {
		this();
		allocate();
		set(copy);
	}

	protected void set(TrackDetected3_20 copy) {
		tracks.set(copy.getTracks());
	}

	public Set<DataSource> getTracks() {
		return tracks.get();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getTracks()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TrackDetected3_20) {
			TrackDetected3_20 trackDetected3_20 = (TrackDetected3_20) obj;
			return new EqualsBuilder().append(getTracks(), trackDetected3_20.getTracks()).isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("tracks", getTracks()).toString();
	}
}
/*
 * Copyright (c) 2018, Andreas Fagschlunger. All rights reserved.
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

package at.o2xfs.xfs.v3_00.ptr;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.win32.DWORD;
import at.o2xfs.win32.LPSTR;
import at.o2xfs.win32.Pointer;
import at.o2xfs.win32.Struct;
import at.o2xfs.xfs.ptr.OffsetY;
import at.o2xfs.xfs.ptr.PaperSource;
import at.o2xfs.xfs.ptr.Resolution;
import at.o2xfs.xfs.ptr.Alignment;
import at.o2xfs.xfs.win32.XfsWord;

public class PrintForm3 extends Struct {

	protected final LPSTR formName = new LPSTR();
	protected final LPSTR mediaName = new LPSTR();
	protected final XfsWord<Alignment> alignment = new XfsWord<>(Alignment.class);
	protected final XfsWord<OffsetY> offsetX = new XfsWord<>(OffsetY.class);
	protected final XfsWord<OffsetY> offsetY = new XfsWord<>(OffsetY.class);
	protected final XfsWord<Resolution> resolution = new XfsWord<>(Resolution.class);
	protected final DWORD mediaControl = new DWORD();
	protected final LPSTR fields = new LPSTR();
	protected final LPSTR uNICODEFields = new LPSTR();
	protected final XfsWord<PaperSource> paperSource = new XfsWord<>(PaperSource.class);

	protected PrintForm3() {
		add(formName);
		add(mediaName);
		add(alignment);
		add(offsetX);
		add(offsetY);
		add(resolution);
		add(mediaControl);
		add(fields);
		add(uNICODEFields);
		add(paperSource);
	}

	public PrintForm3(Pointer p) {
		this();
		assignBuffer(p);
	}

	public PrintForm3(PrintForm3 copy) {
		this();
		allocate();
		set(copy);
	}

	protected void set(PrintForm3 copy) {
		formName.set(copy.getFormName());
		mediaName.set(copy.getMediaName());
		alignment.set(copy.getAlignment());
		offsetX.set(copy.getOffsetX());
		offsetY.set(copy.getOffsetY());
		resolution.set(copy.getResolution());
		mediaControl.set(copy.getMediaControl());
		fields.set(copy.getFields());
		uNICODEFields.set(copy.getUNICODEFields());
		paperSource.set(copy.getPaperSource());
	}

	public String getFormName() {
		return formName.get();
	}

	public String getMediaName() {
		return mediaName.get();
	}

	public Alignment getAlignment() {
		return alignment.get();
	}

	public OffsetY getOffsetX() {
		return offsetX.get();
	}

	public OffsetY getOffsetY() {
		return offsetY.get();
	}

	public Resolution getResolution() {
		return resolution.get();
	}

	public long getMediaControl() {
		return mediaControl.get();
	}

	public String getFields() {
		return fields.get();
	}

	public String getUNICODEFields() {
		return uNICODEFields.get();
	}

	public PaperSource getPaperSource() {
		return paperSource.get();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(getFormName())
				.append(getMediaName())
				.append(getAlignment())
				.append(getOffsetX())
				.append(getOffsetY())
				.append(getResolution())
				.append(getMediaControl())
				.append(getFields())
				.append(getUNICODEFields())
				.append(getPaperSource())
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PrintForm3) {
			PrintForm3 printForm3 = (PrintForm3) obj;
			return new EqualsBuilder()
					.append(getFormName(), printForm3.getFormName())
					.append(getMediaName(), printForm3.getMediaName())
					.append(getAlignment(), printForm3.getAlignment())
					.append(getOffsetX(), printForm3.getOffsetX())
					.append(getOffsetY(), printForm3.getOffsetY())
					.append(getResolution(), printForm3.getResolution())
					.append(getMediaControl(), printForm3.getMediaControl())
					.append(getFields(), printForm3.getFields())
					.append(getUNICODEFields(), printForm3.getUNICODEFields())
					.append(getPaperSource(), printForm3.getPaperSource())
					.isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("formName", getFormName())
				.append("mediaName", getMediaName())
				.append("alignment", getAlignment())
				.append("offsetX", getOffsetX())
				.append("offsetY", getOffsetY())
				.append("resolution", getResolution())
				.append("mediaControl", getMediaControl())
				.append("fields", getFields())
				.append("uNICODEFields", getUNICODEFields())
				.append("paperSource", getPaperSource())
				.toString();
	}
}

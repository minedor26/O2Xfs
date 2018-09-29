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

package at.o2xfs.xfs.v3_20.cdm;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.win32.BOOL;
import at.o2xfs.win32.BufferFactory;
import at.o2xfs.win32.Pointer;
import at.o2xfs.xfs.XfsBuilder;
import at.o2xfs.xfs.v3_10.cdm.CdmCaps310;

public class CdmCaps320 extends CdmCaps310 {

	public static class Builder implements XfsBuilder<CdmCaps320> {

		private final CdmCaps310.Builder builder;

		private boolean antiFraudModule;

		public Builder(CdmCaps310.Builder builder) {
			this.builder = builder;
		}

		public Builder antiFraudModule(boolean antiFraudModule) {
			this.antiFraudModule = antiFraudModule;
			return this;
		}

		@Override
		public CdmCaps320 build(BufferFactory factory) {
			return new CdmCaps320(this, factory);
		}

	}

	protected final BOOL antiFraudModule = new BOOL();

	protected CdmCaps320() {
		add(antiFraudModule);
	}

	public CdmCaps320(Pointer p) {
		this();
		assignBuffer(p);
	}

	protected CdmCaps320(Builder builder, BufferFactory factory) {
		this();
		allocate(factory);
		postConstruct(builder, factory);
	}

	public CdmCaps320(CdmCaps320 copy) {
		this();
		allocate();
		set(copy);
	}

	protected void postConstruct(Builder builder, BufferFactory factory) {
		super.postConstruct(builder.builder, factory);
		antiFraudModule.set(builder.antiFraudModule);
	}

	protected void set(CdmCaps320 copy) {
		super.set(copy);
		antiFraudModule.set(copy.isAntiFraudModule());
	}

	public boolean isAntiFraudModule() {
		return antiFraudModule.get();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().appendSuper(super.hashCode()).append(isAntiFraudModule()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CdmCaps320) {
			CdmCaps320 cdmCaps320 = (CdmCaps320) obj;
			return new EqualsBuilder()
					.appendSuper(super.equals(obj))
					.append(isAntiFraudModule(), cdmCaps320.isAntiFraudModule())
					.isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.appendSuper(super.toString())
				.append("antiFraudModule", isAntiFraudModule())
				.toString();
	}
}

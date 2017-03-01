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

#include "cim/at_o2xfs_xfs_cim_v3_00_StartEx3Test.h"

#include <Windows.h>
#include <XFSCIM.H>
#include "at.o2xfs.win32.h"

static WFSCIMSTARTEX StartEx;
static USHORT usCUNumList[1];
static WFSCIMOUTPUT Output;

JNIEXPORT jobject JNICALL Java_at_o2xfs_xfs_cim_v3_100_StartEx3Test_buildStartEx3(JNIEnv *env, jobject obj) {
	StartEx.fwExchangeType = WFS_CIM_CLEARRECYCLER;
	StartEx.usTellerID = 0;
	StartEx.usCount = 1;
	StartEx.lpusCUNumList = usCUNumList;
	usCUNumList[0] = 1;
	StartEx.lpOutput = &Output;
	Output.usLogicalNumber = 1;
	Output.fwPosition = WFS_CIM_POSOUTFRONT;
	Output.usNumber = 1;
	return NewBuffer(env, &StartEx, sizeof(WFSCIMSTARTEX));
}
/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package libcore.java.security.spec;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.security.spec.EdECPoint;
import java.security.spec.EdECPublicKeySpec;
import java.security.spec.NamedParameterSpec;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EdECPublicKeySpecTest {

    @Test
    public void testConstructor() {
        EdECPoint point = new EdECPoint(true, BigInteger.ONE);
        EdECPublicKeySpec keySpec = new EdECPublicKeySpec(NamedParameterSpec.ED448, point);
        assertEquals(NamedParameterSpec.ED448, keySpec.getParams());
        assertEquals(point.isXOdd(), keySpec.getPoint().isXOdd());
        assertEquals(point.getY(), keySpec.getPoint().getY());

        point = new EdECPoint(false, BigInteger.TEN);
        keySpec = new EdECPublicKeySpec(NamedParameterSpec.ED25519, point);
        assertEquals(NamedParameterSpec.ED25519, keySpec.getParams());
        assertEquals(point.isXOdd(), keySpec.getPoint().isXOdd());
        assertEquals(point.getY(), keySpec.getPoint().getY());
    }
}

/**
 * This file is part of Palmetto.
 *
 * Palmetto is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Palmetto is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Palmetto.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.aksw.palmetto.vector;

import java.util.Arrays;
import java.util.Collection;

import org.aksw.palmetto.calculations.direct.DifferenceBasedConfirmationMeasure;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DifferenceCalculationBasedCreatorTest extends AbstractProbCalcBasedVectorCreatorTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                /*
                 * word1 1 1 1
                 * 
                 * word2 0 1 1
                 * 
                 * word3 0 1 1
                 * 
                 * vector1 0 0 0
                 * 
                 * vector2 0 1/3 1/3
                 * 
                 * vector3 0 1/3 1/3
                 */
                { 3, new double[][] { { 0, 1.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0 } },
                        new double[][][] { { { 0, 0, 0 }, { 0, 1.0 / 3.0, 1.0 / 3.0 }, { 0, 1.0 / 3.0, 1.0 / 3.0 } } },
                        "V_d(1)", 1 },

                /*
                 * word1 0 1 1
                 * 
                 * word2 1 0 1
                 * 
                 * word3 1 1 0
                 * 
                 * vector1 1/3 -1/6 -1/6
                 * 
                 * vector2 -1/6 1/3 -1/6
                 * 
                 * vector3 -1/6 -1/6 1/3
                 */{
                        3,
                        new double[][] { { 0, 2.0 / 3.0, 2.0 / 3.0, 1.0 / 3.0, 2.0 / 3.0, 1.0 / 3.0, 1.0 / 3.0, 0 } },
                        new double[][][] { { { 1.0 / 3.0, -1.0 / 6.0, -1.0 / 6.0 },
                                { -1.0 / 6.0, 1.0 / 3.0, -1.0 / 6.0 }, { -1.0 / 6.0, -1.0 / 6.0, 1.0 / 3.0 } } },
                        "V_d(1)", 1 },
                /*
                 * word1 0 0 0 1
                 * 
                 * word2 0 1 0 1
                 * 
                 * word3 0 0 1 1
                 * 
                 * vector1 3/4 1/4 1/4
                 * 
                 * vector2 1/2 1/2 0
                 * 
                 * vector3 1/2 0 1/2
                 */
                {
                        3,
                        new double[][] { { 0, 0.25, 0.5, 0.25, 0.5, 0.25, 0.25, 0.25 } },
                        new double[][][] { { { 3.0 / 4.0, 1.0 / 4.0, 1.0 / 4.0 }, { 1.0 / 2.0, 1.0 / 2.0, 0 },
                                { 1.0 / 2.0, 0, 1.0 / 2.0 } } }, "V_d(1)", 1 },
                // all together
                {
                        3,
                        new double[][] { { 0, 1.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0 },
                                { 0, 2.0 / 3.0, 2.0 / 3.0, 1.0 / 3.0, 2.0 / 3.0, 1.0 / 3.0, 1.0 / 3.0, 0 },
                                { 0, 0.25, 0.5, 0.25, 0.5, 0.25, 0.25, 0.25 } },
                        new double[][][] {
                                { { 0, 0, 0 }, { 0, 1.0 / 3.0, 1.0 / 3.0 }, { 0, 1.0 / 3.0, 1.0 / 3.0 } },
                                { { 1.0 / 3.0, -1.0 / 6.0, -1.0 / 6.0 }, { -1.0 / 6.0, 1.0 / 3.0, -1.0 / 6.0 },
                                        { -1.0 / 6.0, -1.0 / 6.0, 1.0 / 3.0 } },
                                { { 3.0 / 4.0, 1.0 / 4.0, 1.0 / 4.0 }, { 1.0 / 2.0, 1.0 / 2.0, 0 },
                                        { 1.0 / 2.0, 0, 1.0 / 2.0 } } }, "V_d(1)", 1 },
                /*
                 * word1 1 1 1
                 * 
                 * word2 0 1 1
                 * 
                 * word3 0 1 1
                 * 
                 * vector1 0 0 0
                 * 
                 * vector2 0 1/3 1/3
                 * 
                 * vector3 0 1/3 1/3
                 */
                { 3, new double[][] { { 0, 1.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0 } },
                        new double[][][] { { { 0, 0, 0 }, { 0, 1.0 / 9.0, 1.0 / 9.0 }, { 0, 1.0 / 9.0, 1.0 / 9.0 } } },
                        "V_d(2)", 2 },

                /*
                 * word1 0 1 1
                 * 
                 * word2 1 0 1
                 * 
                 * word3 1 1 0
                 * 
                 * vector1 1/3 -1/6 -1/6
                 * 
                 * vector2 -1/6 1/3 -1/6
                 * 
                 * vector3 -1/6 -1/6 1/3
                 */{
                        3,
                        new double[][] { { 0, 2.0 / 3.0, 2.0 / 3.0, 1.0 / 3.0, 2.0 / 3.0, 1.0 / 3.0, 1.0 / 3.0, 0 } },
                        new double[][][] { { { 1.0 / 9.0, 1.0 / 36.0, 1.0 / 36.0 },
                                { 1.0 / 36.0, 1.0 / 9.0, 1.0 / 36.0 }, { 1.0 / 36.0, 1.0 / 36.0, 1.0 / 9.0 } } },
                        "V_d(2)", 2 },
                /*
                 * word1 0 0 0 1
                 * 
                 * word2 0 1 0 1
                 * 
                 * word3 0 0 1 1
                 * 
                 * vector1 3/4 1/4 1/4
                 * 
                 * vector2 1/2 1/2 0
                 * 
                 * vector3 1/2 0 1/2
                 */
                {
                        3,
                        new double[][] { { 0, 0.25, 0.5, 0.25, 0.5, 0.25, 0.25, 0.25 } },
                        new double[][][] { { { 9.0 / 16.0, 1.0 / 16.0, 1.0 / 16.0 }, { 1.0 / 4.0, 1.0 / 4.0, 0 },
                                { 1.0 / 4.0, 0, 1.0 / 4.0 } } }, "V_d(2)", 2 },
                // all together
                {
                        3,
                        new double[][] { { 0, 1.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0 },
                                { 0, 2.0 / 3.0, 2.0 / 3.0, 1.0 / 3.0, 2.0 / 3.0, 1.0 / 3.0, 1.0 / 3.0, 0 },
                                { 0, 0.25, 0.5, 0.25, 0.5, 0.25, 0.25, 0.25 } },
                        new double[][][] {
                                { { 0, 0, 0 }, { 0, 1.0 / 9.0, 1.0 / 9.0 }, { 0, 1.0 / 9.0, 1.0 / 9.0 } },
                                { { 1.0 / 9.0, 1.0 / 36.0, 1.0 / 36.0 }, { 1.0 / 36.0, 1.0 / 9.0, 1.0 / 36.0 },
                                        { 1.0 / 36.0, 1.0 / 36.0, 1.0 / 9.0 } },
                                { { 9.0 / 16.0, 1.0 / 16.0, 1.0 / 16.0 }, { 1.0 / 4.0, 1.0 / 4.0, 0 },
                                        { 1.0 / 4.0, 0, 1.0 / 4.0 } } }, "V_d(2)", 2 } });
    }

    public DifferenceCalculationBasedCreatorTest(int wordsetSize, double[][] probabilities,
            double[][][] expectedVectors, String expectedCreatorName, double gamma) {
        super(new DifferenceBasedConfirmationMeasure(), wordsetSize, probabilities, expectedVectors,
                expectedCreatorName, gamma);
    }
}

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
package org.aksw.palmetto.aggregation;

public class ArithmeticMean implements Aggregation {

    @Override
    public double summarize(double[] values) {
        double sum = 0;
        for (int i = 0; i < values.length; ++i) {
            sum += values[i];
        }
        return sum / (double) values.length;
    }

    @Override
    public String getName() {
        return "sigma_a";
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public double summarize(double[] values, double[] weights) {
        double weightSum = 0, sum = 0;
        for (int i = 0; i < values.length; ++i) {
            if (!Double.isNaN(values[i])) {
                sum += weights[i] * values[i];
                weightSum += weights[i];
            }
        }
        if (weightSum > 0) {
            return sum / weightSum;
        } else {
            return 0;
        }
    }
}

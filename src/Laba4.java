// Polyukhovych Nastya IO-82

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;


public class Laba4 {

    public static void main(String[] args) {

        double[][] CohrenaTable = {
                {.0, .0, .0, .0, .0, .0, .0, .0, .0, .0},
                {.9985, .9750, .9392, .9057, .8772, .8534, .8332, .8159, .8010, .7880},
                {.9669, .8709, .7977, .7457, .7071, .6771, .6530, .6333, .6167, .6025},
                {.9065, .7679, .6841, .6287, .5892, .5598, .5365, .5175, .5017, .4884},
                {.8412, .6838, .5981, .5440, .5063, .4783, .4564, .4387, .4241, .4118},
                {.7808, .6161, .5321, .4803, .4447, .4184, .3980, .3817, .3682, .3568},
                {.7271, .5612, .4800, .4307, .3974, .3726, .3535, .3384, .3259, .3154},
                {.6798, .5157, .4377, .3910, .3595, .3362, .3185, .3043, .2926, .2829},
                {.6385, .4775, .4027, .3584, .3286, .3067, .2901, .2768, .2659, .2568},
                {.6020, .4450, .3733, .3311, .3029, .2823, .2666, .2541, .2439, .2353},
        };

        double[] StudentaTable = {12.71, 4.303, 3.182, 2.776, 2.571, 2.447, 2.365, 2.306, 2.262,
                2.228, 2.201, 2.179, 2.160, 2.145, 2.131, 2.12, 2.11, 2.101, 2.093, 2.086,
                2.08, 2.074, 2.069, 2.064, 2.06, 2.056, 2.052, 2.048, 2.045, 2.042, 1.960
        };

        int x1Min = -25, x2Min = -20, x3Min = -25, x1Max = 75, x2Max = 60, x3Max = -10,
                xAverageMax = (x1Max + x2Max + x3Max) / 3, xAverageMin = (x1Min + x2Min + x3Min) / 3,
                yMax = 200 + xAverageMax, yMin = 200 + xAverageMin, N = 8, m = 3, f1 = m - 1, f2 = N, f3 = f1 * f2;

        int[][] matrixForX = {
                {-25, -20, -25},
                {-25, -20, -10},
                {-25, 60, -25},
                {-25, 60, -10},
                {75, -20, -25},
                {75, -20, -10},
                {75, 60, -25},
                {75, 60, -10},
        };

        int[][] matrixForY = new int[8][3];
        int averageY1 = 0, averageY2 = 0, averageY3 = 0, averageY4 = 0,
                averageY5 = 0, averageY6 = 0, averageY7 = 0, averageY8 = 0;

        //матриця для у
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 3; j++) {
                matrixForY[i][j] = yMin + (int) (Math.random() * (yMax - yMin));
            }
        }
        System.out.println("Матриця Х : " + Arrays.deepToString(matrixForX));
        System.out.println("Матриця У : " + Arrays.deepToString(matrixForY));


        for (int j = 0; j < 3; j++) {
            averageY1 += matrixForY[0][j] / 3;
            averageY2 += matrixForY[1][j] / 3;
            averageY3 += matrixForY[2][j] / 3;
            averageY4 += matrixForY[3][j] / 3;
            averageY5 += matrixForY[4][j] / 3;
            averageY6 += matrixForY[5][j] / 3;
            averageY7 += matrixForY[6][j] / 3;
            averageY8 += matrixForY[7][j] / 3;
        }

        System.out.println("середнє значення функції відгуку для 1 рядка = " + averageY1);
        System.out.println("середнє значення функції відгуку для 2 рядка = " + averageY2);
        System.out.println("середнє значення функції відгуку для 3 рядка = " + averageY3);
        System.out.println("середнє значення функції відгуку для 4 рядка = " + averageY4);
        System.out.println("середнє значення функції відгуку для 5 рядка = " + averageY5);
        System.out.println("середнє значення функції відгуку для 6 рядка = " + averageY6);
        System.out.println("середнє значення функції відгуку для 7 рядка = " + averageY7);
        System.out.println("середнє значення функції відгуку для 8 рядка = " + averageY8);

        double my = (averageY1 + averageY2 + averageY3 + averageY4 + averageY5 + averageY6 + averageY7 + averageY8) / 8,
                mx1, mx2, mx3, mx1suma = 0.0, mx2suma = 0.0, mx3suma = 0.0;

        double[] matrixForYi = {averageY1, averageY2, averageY3, averageY4, averageY5, averageY6, averageY7, averageY8};
        for (int i = 0; i < 8; i++) {
            mx1suma += matrixForX[i][0];
            mx2suma += matrixForX[i][1];
            mx3suma += matrixForX[i][2];
        }
        mx1 = mx1suma / 8;
        mx2 = mx2suma / 8;
        mx3 = mx3suma / 8;

        System.out.println("My = " + my);
        System.out.println("Mx1 = " + mx1);
        System.out.println("Mx2 = " + mx2);
        System.out.println("Mx3 = " + mx3);


        double x123i = 0, x1i = 0, x2i = 0, x3i = 0, x12i = 0, x13i = 0, x23i = 0,
                m00 = 0, m01 = 0, m02 = 0, m03 = 0, m04 = 0, m05 = 0, m06 = 0, m07 = 0, m10 = 0, m11 = 0, m12 = 0, m13 = 0, m14 = 0,
                m15 = 0, m16 = 0, m17 = 0, m20 = 0, m21 = 0, m22 = 0, m23 = 0, m24 = 0, m25 = 0, m26 = 0, m27 = 0, m30 = 0, m31 = 0, m32 = 0, m33 = 0,
                m34 = 0, m35 = 0, m36 = 0, m37 = 0, m40 = 0, m41 = 0, m42 = 0, m43 = 0, m44 = 0, m45 = 0,
                m46 = 0, m47 = 0, m50 = 0, m51 = 0, m52 = 0, m53 = 0, m54 = 0, m55 = 0, m56 = 0, m57 = 0, m60 = 0, m61 = 0, m62 = 0, m63 = 0,
                m64 = 0, m65 = 0, m66 = 0, m67 = 0, m70 = 0, m71 = 0,
                m72 = 0, m73 = 0, m74 = 0, m75 = 0, m76 = 0, m77 = 0,
                k0 = 0, k1 = 0, k2 = 0, k3 = 0, k4 = 0, k5 = 0, k6 = 0, k7 = 0;


        //шукаємо коефіцієнти для визначників
        for (int i = 0; i < 8; i++) {

            x123i = matrixForX[i][0] * matrixForX[i][1] * matrixForX[i][2];
            x1i = matrixForX[i][0];
            x2i = matrixForX[i][1];
            x3i = matrixForX[i][2];
            x12i = x1i * x2i;
            x13i = x1i * x3i;
            x23i = x2i * x3i;

            m00 = N;
            m01 += x1i;
            m02 += x2i;
            m03 += x3i;
            m04 += x12i;
            m05 += x13i;
            m06 += x23i;
            m07 += x123i;

            m10 += x1i;
            m11 += Math.pow(x1i, 2);
            m12 += x12i;
            m13 += x13i;
            m14 += Math.pow(x1i, 2) * x2i;
            m15 += Math.pow(x1i, 2) * x3i;
            m16 += x123i;
            m17 += Math.pow(x1i, 2) * x23i;

            m20 += x2i;
            m21 += x12i;
            m22 += Math.pow(x2i, 2);
            m23 += x23i;
            m24 += Math.pow(x2i, 2) * x1i;
            m25 += x123i;
            m26 += Math.pow(x2i, 2) * x3i;
            m27 += Math.pow(x2i, 2) * x13i;

            m30 += x3i;
            m31 += x13i;
            m32 += x23i;
            m33 += Math.pow(x3i, 2);
            m34 += x123i;
            m35 += Math.pow(x3i, 2) * x1i;
            m36 += Math.pow(x3i, 2) * x2i;
            m37 += Math.pow(x3i, 2) * x12i;

            m40 += x12i;
            m41 += Math.pow(x1i, 2) * x2i;
            m42 += x1i * Math.pow(x2i, 2);
            m43 += x123i;
            m44 += Math.pow(x1i, 2) * Math.pow(x2i, 2);
            m45 += Math.pow(x1i, 2) * x23i;
            m46 += x13i * Math.pow(x2i, 2);
            m47 += Math.pow(x2i, 2) * Math.pow(x1i, 2) * x3i;

            m50 += x13i;
            m51 += Math.pow(x1i, 2) * x3i;
            m52 += x123i;
            m53 += x1i * Math.pow(x3i, 2);
            m54 += Math.pow(x1i, 2) * x23i;
            m55 += Math.pow(x1i, 2) * Math.pow(x3i, 2);
            m56 += Math.pow(x3i, 2) * x12i;
            m57 += Math.pow(x3i, 2) * Math.pow(x1i, 2) * x2i;


            m60 += x23i;
            m61 += x123i;
            m62 += x3i * Math.pow(x2i, 2);
            m63 += x2i * Math.pow(x3i, 2);
            m64 += x13i * Math.pow(x2i, 2);
            m65 += x12i * Math.pow(x3i, 2);
            m66 += Math.pow(x2i, 2) * Math.pow(x3i, 2);
            m67 += Math.pow(x2i, 2) * Math.pow(x3i, 2) * x1i;

            m70 += x123i;
            m71 += Math.pow(x1i, 2) * x23i;
            m72 += x13i * Math.pow(x2i, 2);
            m73 += x12i * Math.pow(x3i, 2);
            m74 += Math.pow(x1i, 2) * Math.pow(x2i, 2) * x3i;
            m75 += Math.pow(x1i, 2) * Math.pow(x3i, 2) * x2i;
            m76 += x1i * Math.pow(x2i, 2) * Math.pow(x3i, 2);
            m77 += Math.pow(x2i, 2) * Math.pow(x3i, 2) * Math.pow(x1i, 2);

            k0 += matrixForYi[i];
            k1 += matrixForYi[i] * x1i;
            k2 += matrixForYi[i] * x2i;
            k3 += matrixForYi[i] * x3i;
            k4 += matrixForYi[i] * x12i;
            k5 += matrixForYi[i] * x13i;
            k6 += matrixForYi[i] * x23i;
            k7 += matrixForYi[i] * x123i;

        }


        double[][] det = {
                {m00, m10, m20, m30, m40, m50, m60, m70},
                {m01, m11, m21, m31, m41, m51, m61, m71},
                {m02, m12, m22, m32, m42, m52, m62, m72},
                {m03, m13, m23, m33, m43, m53, m63, m73},
                {m04, m14, m24, m34, m44, m54, m64, m74},
                {m05, m15, m25, m35, m45, m55, m65, m75},
                {m06, m16, m26, m36, m46, m56, m66, m76},
                {m07, m17, m27, m37, m47, m57, m67, m77},

        };

        double[][] b0 = {
                {k0, m10, m20, m30, m40, m50, m60, m70},
                {k1, m11, m21, m31, m41, m51, m61, m71},
                {k2, m12, m22, m32, m42, m52, m62, m72},
                {k3, m13, m23, m33, m43, m53, m63, m73},
                {k4, m14, m24, m34, m44, m54, m64, m74},
                {k5, m15, m25, m35, m45, m55, m65, m75},
                {k6, m16, m26, m36, m46, m56, m66, m76},
                {k7, m17, m27, m37, m47, m57, m67, m77},

        };

        double[][] b1 = {
                {m00, k0, m20, m30, m40, m50, m60, m70},
                {m01, k1, m21, m31, m41, m51, m61, m71},
                {m02, k2, m22, m32, m42, m52, m62, m72},
                {m03, k3, m23, m33, m43, m53, m63, m73},
                {m04, k4, m24, m34, m44, m54, m64, m74},
                {m05, k5, m25, m35, m45, m55, m65, m75},
                {m06, k6, m26, m36, m46, m56, m66, m76},
                {m07, k7, m27, m37, m47, m57, m67, m77},

        };
        double[][] b2 = {
                {m00, m10, k0, m30, m40, m50, m60, m70},
                {m01, m11, k1, m31, m41, m51, m61, m71},
                {m02, m12, k2, m32, m42, m52, m62, m72},
                {m03, m13, k3, m33, m43, m53, m63, m73},
                {m04, m14, k4, m34, m44, m54, m64, m74},
                {m05, m15, k5, m35, m45, m55, m65, m75},
                {m06, m16, k6, m36, m46, m56, m66, m76},
                {m07, m17, k7, m37, m47, m57, m67, m77},

        };
        double[][] b3 = {
                {m00, m10, m20, k0, m40, m50, m60, m70},
                {m01, m11, m21, k1, m41, m51, m61, m71},
                {m02, m12, m22, k2, m42, m52, m62, m72},
                {m03, m13, m23, k3, m43, m53, m63, m73},
                {m04, m14, m24, k4, m44, m54, m64, m74},
                {m05, m15, m25, k5, m45, m55, m65, m75},
                {m06, m16, m26, k6, m46, m56, m66, m76},
                {m07, m17, m27, k7, m47, m57, m67, m77},

        };
        double[][] b12 = {
                {m00, m10, m20, m30, k0, m50, m60, m70},
                {m01, m11, m21, m31, k1, m51, m61, m71},
                {m02, m12, m22, m32, k2, m52, m62, m72},
                {m03, m13, m23, m33, k3, m53, m63, m73},
                {m04, m14, m24, m34, k4, m54, m64, m74},
                {m05, m15, m25, m35, k5, m55, m65, m75},
                {m06, m16, m26, m36, k6, m56, m66, m76},
                {m07, m17, m27, m37, k7, m57, m67, m77},

        };
        double[][] b13 = {
                {m00, m10, m20, m30, m40, k0, m60, m70},
                {m01, m11, m21, m31, m41, k1, m61, m71},
                {m02, m12, m22, m32, m42, k2, m62, m72},
                {m03, m13, m23, m33, m43, k3, m63, m73},
                {m04, m14, m24, m34, m44, k4, m64, m74},
                {m05, m15, m25, m35, m45, k5, m65, m75},
                {m06, m16, m26, m36, m46, k6, m66, m76},
                {m07, m17, m27, m37, m47, k7, m67, m77},

        };
        double[][] b23 = {
                {m00, m10, m20, m30, m40, m50, k0, m70},
                {m01, m11, m21, m31, m41, m51, k1, m71},
                {m02, m12, m22, m32, m42, m52, k2, m72},
                {m03, m13, m23, m33, m43, m53, k3, m73},
                {m04, m14, m24, m34, m44, m54, k4, m74},
                {m05, m15, m25, m35, m45, m55, k5, m75},
                {m06, m16, m26, m36, m46, m56, k6, m76},
                {m07, m17, m27, m37, m47, m57, k7, m77},

        };
        double[][] b123 = {
                {m00, m10, m20, m30, m40, m50, m60, k0},
                {m01, m11, m21, m31, m41, m51, m61, k1},
                {m02, m12, m22, m32, m42, m52, m62, k2},
                {m03, m13, m23, m33, m43, m53, m63, k3},
                {m04, m14, m24, m34, m44, m54, m64, k4},
                {m05, m15, m25, m35, m45, m55, m65, k5},
                {m06, m16, m26, m36, m46, m56, m66, k6},
                {m07, m17, m27, m37, m47, m57, m67, k7},

        };


        DeterminantCalc determinantCalcb0 = new DeterminantCalc(b0);
        DeterminantCalc determinantCalcb1 = new DeterminantCalc(b1);
        DeterminantCalc determinantCalcb2 = new DeterminantCalc(b2);
        DeterminantCalc determinantCalcb3 = new DeterminantCalc(b3);
        DeterminantCalc determinantCalcb12 = new DeterminantCalc(b12);
        DeterminantCalc determinantCalcb13 = new DeterminantCalc(b13);
        DeterminantCalc determinantCalcb23 = new DeterminantCalc(b23);
        DeterminantCalc determinantCalcb123 = new DeterminantCalc(b123);
        DeterminantCalc determinantCalcDet = new DeterminantCalc(det);


        BigDecimal koefB0 = determinantCalcb0.determinant().divide(determinantCalcDet.determinant(), 8, RoundingMode.HALF_EVEN);
        BigDecimal koefB1 = determinantCalcb1.determinant().divide(determinantCalcDet.determinant(), 8, RoundingMode.HALF_EVEN);
        BigDecimal koefB2 = determinantCalcb2.determinant().divide(determinantCalcDet.determinant(), 8, RoundingMode.HALF_EVEN);
        BigDecimal koefB3 = determinantCalcb3.determinant().divide(determinantCalcDet.determinant(), 8, RoundingMode.HALF_EVEN);
        BigDecimal koefB12 = determinantCalcb12.determinant().divide(determinantCalcDet.determinant(), 8, RoundingMode.HALF_EVEN);
        BigDecimal koefB13 = determinantCalcb13.determinant().divide(determinantCalcDet.determinant(), 8, RoundingMode.HALF_EVEN);
        BigDecimal koefB23 = determinantCalcb23.determinant().divide(determinantCalcDet.determinant(), 8, RoundingMode.HALF_EVEN);
        BigDecimal koefB123 = determinantCalcb123.determinant().divide(determinantCalcDet.determinant(), 8, RoundingMode.HALF_EVEN);

        System.out.println();
        System.out.println("Рівняння регресії : " + "Y = " + koefB0 + " + " + koefB1 + "*X1 + " + koefB2
                + "*X2 + " + koefB3 + "*X3 + " + koefB12 + "*X1*X2 + " + koefB13 + "*X3*X1 + " + koefB23 +
                "*X3 * X2 + " + koefB123 + "*X3*X2*X1");
        System.out.println("Перевірка : ");

        double test=0;
        for (int i = 0; i < 8; i++) {

            test = koefB0.doubleValue()
                    + koefB1.doubleValue() * matrixForX[i][0]
                    + koefB2.doubleValue() * matrixForX[i][1]
                    + koefB3.doubleValue() * matrixForX[i][2]
                    + koefB12.doubleValue() * matrixForX[i][0] * matrixForX[i][1]
                    + koefB13.doubleValue() * matrixForX[i][2] * matrixForX[i][0]
                    + koefB23.doubleValue() * matrixForX[i][2] * matrixForX[i][1]
                    + koefB123.doubleValue() * matrixForX[i][1] * matrixForX[i][0] * matrixForX[i][2];
            System.out.println("Перевірка, значення у" + (i + 1) + " :  " + test);
        }


        /**                    Перевірка однорідності дисперсії за критерієм Кохрена                                          */

        int[][] mainMatrix = {
                {1, -1, -1, -1,  1,  1,  1, -1},
                {1, -1, -1,  1,  1, -1, -1,  1},
                {1, -1,  1, -1, -1,  1, -1,  1},
                {1, -1,  1,  1, -1, -1,  1, -1},
                {1,  1, -1, -1, -1, -1,  1,  1},
                {1,  1, -1,  1, -1,  1, -1, -1},
                {1,  1,  1, -1,  1, -1, -1, -1},
                {1,  1,  1,  1,  1,  1,  1,  1},
        };

        // дисперсія
        double dispersion1 = 0, dispersion2 = 0, dispersion3 = 0, dispersion4 = 0,
                dispersion5 = 0, dispersion6 = 0, dispersion7 = 0, dispersion8 = 0;
        for (int j = 0; j < 3; j++) {
            dispersion1 += (Math.pow((matrixForY[0][j] - averageY1), 2)) / 3;
            dispersion2 += (Math.pow((matrixForY[1][j] - averageY2), 2)) / 3;
            dispersion3 += (Math.pow((matrixForY[2][j] - averageY3), 2)) / 3;
            dispersion4 += (Math.pow((matrixForY[3][j] - averageY4), 2)) / 3;
            dispersion5 += (Math.pow((matrixForY[4][j] - averageY5), 2)) / 3;
            dispersion6 += (Math.pow((matrixForY[5][j] - averageY6), 2)) / 3;
            dispersion7 += (Math.pow((matrixForY[6][j] - averageY7), 2)) / 3;
            dispersion8 += (Math.pow((matrixForY[7][j] - averageY8), 2)) / 3;
        }
        System.out.println();
        System.out.println("дисперсія 1 = " + dispersion1);
        System.out.println("дисперсія 2 = " + dispersion2);
        System.out.println("дисперсія 3 = " + dispersion3);
        System.out.println("дисперсія 4 = " + dispersion4);
        System.out.println("дисперсія 5 = " + dispersion5);
        System.out.println("дисперсія 6 = " + dispersion6);
        System.out.println("дисперсія 7 = " + dispersion7);
        System.out.println("дисперсія 8 = " + dispersion8);

        int numberOfY = 3;
        double maxDispersion = Math.max(Math.max(Math.max(dispersion1, dispersion2), Math.max(dispersion3, dispersion4)),
                Math.max(Math.max(dispersion5, dispersion6), Math.max(dispersion7, dispersion8)));
        double sumOfDispersion = dispersion1 + dispersion2 + dispersion3 + dispersion4 + dispersion5 + dispersion6 + dispersion7 + dispersion8;
        double gp = maxDispersion / sumOfDispersion;
        if (gp > CohrenaTable[f2 - 1][f1 - 1]) {

            System.out.println("Gp = " + gp + " >   " + CohrenaTable[f2 - 1][f1 - 1]);
            System.out.println();
            System.out.println("Збільшимо кількість дослідів і повторимо перевірку");
            numberOfY += 1;
            int[][] matrixForYNew = new int[8][numberOfY];
            System.out.println("Кількість у = " + numberOfY);

            //матриця для нового у
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < numberOfY; j++) {
                    matrixForYNew[i][j] = yMin + (int) (Math.random() * (yMax - yMin));
                }
            }

            for (int j = 0; j < numberOfY; j++) {
                averageY1 += matrixForYNew[0][j] / numberOfY;
                averageY2 += matrixForYNew[1][j] / numberOfY;
                averageY3 += matrixForYNew[2][j] / numberOfY;
                averageY4 += matrixForYNew[3][j] / numberOfY;
                averageY5 += matrixForYNew[4][j] / numberOfY;
                averageY6 += matrixForYNew[5][j] / numberOfY;
                averageY7 += matrixForYNew[6][j] / numberOfY;
                averageY8 += matrixForYNew[7][j] / numberOfY;
            }

            double dispersionNew1 = 0, dispersionNew2 = 0, dispersionNew3 = 0, dispersionNew4 = 0,
                    dispersionNew5 = 0, dispersionNew6 = 0, dispersionNew7 = 0, dispersionNew8 = 0;
            for (int j = 0; j < numberOfY; j++) {
                dispersionNew1 += (Math.pow((matrixForYNew[0][j] - averageY1), 2)) / 4;
                dispersionNew2 += (Math.pow((matrixForYNew[1][j] - averageY2), 2)) / 4;
                dispersionNew3 += (Math.pow((matrixForYNew[2][j] - averageY3), 2)) / 4;
                dispersionNew4 += (Math.pow((matrixForYNew[3][j] - averageY4), 2)) / 4;
                dispersionNew5 += (Math.pow((matrixForYNew[4][j] - averageY5), 2)) / 4;
                dispersionNew6 += (Math.pow((matrixForYNew[5][j] - averageY6), 2)) / 4;
                dispersionNew7 += (Math.pow((matrixForYNew[6][j] - averageY7), 2)) / 4;
                dispersionNew8 += (Math.pow((matrixForYNew[7][j] - averageY8), 2)) / 4;
            }

            System.out.println();
            System.out.println("дисперсія 1 = " + dispersionNew1);
            System.out.println("дисперсія 2 = " + dispersionNew2);
            System.out.println("дисперсія 3 = " + dispersionNew3);
            System.out.println("дисперсія 4 = " + dispersionNew4);
            System.out.println("дисперсія 5 = " + dispersionNew5);
            System.out.println("дисперсія 6 = " + dispersionNew6);
            System.out.println("дисперсія 7 = " + dispersionNew7);
            System.out.println("дисперсія 8 = " + dispersionNew8);

            double maxDispersionNew = Math.max(Math.max(Math.max(dispersionNew1, dispersionNew2), Math.max(dispersionNew3, dispersionNew4)),
                    Math.max(Math.max(dispersionNew5, dispersionNew6), Math.max(dispersionNew7, dispersionNew8)));
            double gpNew = maxDispersionNew / (dispersionNew1 + dispersionNew2 + dispersionNew3 + dispersionNew4
                    + dispersionNew5 + dispersionNew6 + dispersionNew7 + dispersionNew8);
            System.out.println("GpNew = " + gpNew + " < " + CohrenaTable[f2 - 2][f1 - 1]);
            System.out.println("Дисперсія однорідна (Перевірено за критерієм Кохрена)");
        } else {
            System.out.println();
            System.out.println("Gp = " + gp + " < " + CohrenaTable[f2 - 1][f1 - 1]);
            System.out.println("Дисперсія однорідна (Перевірено за критерієм Кохрена)");
        }


        /**                   Далі оцінимо значимість коефіцієнтів регресії згідно критерію Стьюдента                                         */
        /**                                              Критерій Фішера                                             */


        double sb = sumOfDispersion / N,
                t = StudentaTable[f3 - 1],
                sBetta = Math.sqrt(sb / (N * m)),
                betta0 = (averageY1 * mainMatrix[0][0] + averageY2 * mainMatrix[1][0] + averageY3 * mainMatrix[2][0] + averageY4 * mainMatrix[3][0]
                        + averageY5 * mainMatrix[4][0] + averageY6 * mainMatrix[5][0] + averageY7 * mainMatrix[6][0] + averageY8 * mainMatrix[7][0]) ,
                betta1 = (averageY1 * mainMatrix[0][1] + averageY2 * mainMatrix[1][1] + averageY3 * mainMatrix[2][1] + averageY4 * mainMatrix[3][1]
                        + averageY5 * mainMatrix[4][1] + averageY6 * mainMatrix[5][1] + averageY7 * mainMatrix[6][1] + averageY8 * mainMatrix[7][1]) ,
                betta2 = (averageY1 * mainMatrix[0][2] + averageY2 * mainMatrix[1][2] + averageY3 * mainMatrix[2][2] + averageY4 * mainMatrix[3][2]
                        + averageY5 * mainMatrix[4][2] + averageY6 * mainMatrix[5][2] + averageY7 * mainMatrix[6][2] + averageY8 * mainMatrix[7][2]),
                betta3 = (averageY1 * mainMatrix[0][3] + averageY2 * mainMatrix[1][3] + averageY3 * mainMatrix[2][3] + averageY4 * mainMatrix[3][3]
                        + averageY5 * mainMatrix[4][3] + averageY6 * mainMatrix[5][3] + averageY7 * mainMatrix[6][3] + averageY8 * mainMatrix[7][3]) ,
                betta4 = (averageY1 * mainMatrix[0][4] + averageY2 * mainMatrix[1][4] + averageY3 * mainMatrix[2][4] + averageY4 * mainMatrix[3][4]
                        + averageY5 * mainMatrix[4][4] + averageY6 * mainMatrix[5][4] + averageY7 * mainMatrix[6][4] + averageY8 * mainMatrix[7][4]) ,
                betta5 = (averageY1 * mainMatrix[0][5] + averageY2 * mainMatrix[1][5] + averageY3 * mainMatrix[2][5] + averageY4 * mainMatrix[3][5]
                        + averageY5 * mainMatrix[4][5] + averageY6 * mainMatrix[5][5] + averageY7 * mainMatrix[6][5] + averageY8 * mainMatrix[7][5]) ,
                betta6 = (averageY1 * mainMatrix[0][6] + averageY2 * mainMatrix[1][6] + averageY3 * mainMatrix[2][6] + averageY4 * mainMatrix[3][6]
                        + averageY5 * mainMatrix[4][6] + averageY6 * mainMatrix[5][6] + averageY7 * mainMatrix[6][6] + averageY8 * mainMatrix[7][6]) ,
                betta7 = (averageY1 * mainMatrix[0][7] + averageY2 * mainMatrix[1][7] + averageY3 * mainMatrix[2][7] + averageY4 * mainMatrix[3][7]
                        + averageY5 * mainMatrix[4][7] + averageY6 * mainMatrix[5][7] + averageY7 * mainMatrix[6][7] + averageY8 * mainMatrix[7][7]) ,

                t0 = Math.abs(betta0/N) / sBetta,
                t1 = Math.abs(betta1/N) / sBetta,
                t2 = Math.abs(betta2/N) / sBetta,
                t3 = Math.abs(betta3/N) / sBetta,
                t4 = Math.abs(betta4/N) / sBetta,
                t5 = Math.abs(betta5/N) / sBetta,
                t6 = Math.abs(betta6/N) / sBetta,
                t7 = Math.abs(betta7/N) / sBetta;

        int d = 8;
        boolean b0Boolean , b1Boolean , b2Boolean ,b3Boolean ,b12Boolean ,b13Boolean ,b23Boolean ,b123Boolean ;
        if (t0 < t) {
            System.out.println("Із перевірки виходить , що коефіцієнт b0 незначимий   " + t0 + " < " + t);
            d -= 1;
            b0Boolean = false;
        } else {
            System.out.println("Із перевірки виходить , що коефіцієнт b0 значимий   " + t0 + " > " + t);
            b0Boolean = true;
        }
        if (t1 < t) {
            System.out.println("Із перевірки виходить , що коефіцієнт b1 незначимий  " + t1 + " < " + t);
            d -= 1;
            b1Boolean = false;
        } else {
            System.out.println("Із перевірки виходить , що коефіцієнт b1 значимий  " + t1 + " > " + t);
            b1Boolean = true;
        }
        if (t2 < t) {
            System.out.println("Із перевірки виходить , що коефіцієнт b2 незначимий  " + t2 + " < " + t);
            d -= 1;
            b2Boolean = false;
        } else {
            System.out.println("Із перевірки виходить , що коефіцієнт b2 значимий   " + t2 + " > " + t);
            b2Boolean = true;
        }
        if (t3 < t) {
            System.out.println("Із перевірки виходить , що коефіцієнт b3 незначимий  " + t3 + " < " + t);
            d -= 1;
            b3Boolean = false;
        } else {
            System.out.println("Із перевірки виходить , що коефіцієнт b3 значимий  " + t3 + " > " + t);
            b3Boolean = true;
        }
        if (t4 < t) {
            System.out.println("Із перевірки виходить , що коефіцієнт b12 незначимий  " + t4 + " < " + t);
            d -= 1;
            b12Boolean = false;
        } else {
            System.out.println("Із перевірки виходить , що коефіцієнт b12 значимий  " + t4 + " > " + t);
            b12Boolean = true;
        }
        if (t5 < t) {
            System.out.println("Із перевірки виходить , що коефіцієнт b13 незначимий  " + t5 + " < " + t);
            d -= 1;
            b13Boolean = false;
        } else {
            System.out.println("Із перевірки виходить , що коефіцієнт b13 значимий  " + t5 + " > " + t);
            b13Boolean = true;
        }
        if (t6 < t) {
            System.out.println("Із перевірки виходить , що коефіцієнт b23 незначимий  " + t6 + " < " + t);
            d -= 1;
            b23Boolean = false;
        } else {
            System.out.println("Із перевірки виходить , що коефіцієнт b23 значимий  " + t6 + " > " + t);
            b23Boolean = true;
        }
        if (t7 < t) {
            System.out.println("Із перевірки виходить , що коефіцієнт b123 незначимий  " + t7 + " < " + t);
            d -= 1;
            b123Boolean = false;
        } else {
            System.out.println("Із перевірки виходить , що коефіцієнт b123 значимий  " + t7 + " > " + t);
            b123Boolean = true;
        }

        boolean[] koefbArray = {b0Boolean,b1Boolean,b2Boolean,b3Boolean,b12Boolean,b13Boolean,b23Boolean,b123Boolean};
        int f4 = N - d;
        double[] averageY = {averageY1,averageY2,averageY3,averageY4,averageY5,averageY6,averageY7,averageY8};
        double sum =0;
        if (f4 == 0) {
            System.out.println("Неможливо порахувати критерій Фішера , оскільки f4 = 0 ");
        } else {

            if (d == N) {
                System.out.println("Рівняння регресії залишається без змін");
            }
            else {
                System.out.println();
                System.out.println("Нове рівняння регресії , ");
                double[] testArray = new double[8];
                double[] qArray = new double[8];

                for (int i = 0; i < 8; i++) {
                    String[] qArrayString = {"b0", "b1", "b2", "b3", "b12", "b13", "b23", "b123"};
                    if (koefbArray[i]) {
                        System.out.println("залишається коефіцієнт : " + qArrayString[i]);
                        for (int j = 0; j < 8; j++) {
                            qArray[0] = koefB0.doubleValue();
                            qArray[1] = koefB1.doubleValue() * matrixForX[j][0];
                            qArray[2] = koefB2.doubleValue() * matrixForX[j][1];
                            qArray[3] = koefB3.doubleValue() * matrixForX[j][2];
                            qArray[4] = koefB12.doubleValue() * matrixForX[j][0] * matrixForX[j][1];
                            qArray[5] = koefB13.doubleValue() * matrixForX[j][2] * matrixForX[j][0];
                            qArray[6] = koefB23.doubleValue() * matrixForX[j][2] * matrixForX[j][1];
                            qArray[7] = koefB123.doubleValue() * matrixForX[j][1] * matrixForX[j][0] * matrixForX[j][2];
                            testArray[j] += qArray[i];
                        }
                    }
                }
                System.out.println();
                sum=0;
                for (int i = 0; i < 8; i++) {
                    System.out.println("Перевірка, у"+(i+1)+ " : " + testArray[i]);
                    sum += Math.pow((averageY[i] - testArray[i]),2);
                }
            }
        }
        FisheraMethod(sum,d,sb,f3,f4,N);
    }


    public static void FisheraMethod (double sum , int d , double sb , int f3 , int f4, int N){

        double[][] FisheraTable = {
                {164.4, 199.5, 215.7, 224.6, 230.2, 234,244.9,249.0,254.3},
                {18.5, 19.2, 19.2, 19.3, 19.3, 19.3,19.4,19.4,19.5},
                {10.1, 9.6, 9.3, 9.1, 9, 8.9,8.7,8.6,8.5},
                {7.7, 6.9, 6.6, 6.4, 6.3, 6.2, 5.9,5.8,5.6},
                {6.6, 5.8, 5.4, 5.2, 5.1, 5,4.7,4.5,4.4},
                {6, 5.1, 4.8, 4.5, 4.4, 4.3,4,3.8,3.7},
                {5.5, 4.7, 4.4, 4.1, 4, 3.9, 3.6,3.4,3.2},
                {5.3, 4.5, 4.1, 3.8, 3.7, 3.6 , 3.3,3.1,2.9},
                {5.1, 4.3, 3.9, 3.6, 3.5, 3.4, 3.1,2.9,2.7},
                {5, 4.1, 3.7, 3.5, 3.3, 3.2, 2.9, 2.7,2.5},
                {4.8, 4, 3.6, 3.4, 3.2, 3.1, 2.8,2.6,2.4},
                {4.8, 3.9, 3.5, 3.3, 3.1, 3, 2.7,2.5,2.3},
                {4.7, 3.8, 3.4, 3.2, 3, 2.9, 2.6, 2.4,2.2},
                {4.6, 3.7, 3.3, 3.1, 3, 2.9, 2.5,2.3,2.1},
                {4.5, 3.7, 3.3, 3.1, 2.9, 2.8,2.5,2.3,2.1 },
                {4.5, 3.6, 3.2, 3, 2.9, 2.7, 2.4,2.2,2},
                {4.5, 3.6, 3.2, 3, 2.8, 2.7 , 2.4,2.2,2},
                {4.4, 3.6, 3.2, 2.9, 2.8, 2.7, 2.3,2.1,1.9},
                {4.4, 3.5, 3.1, 2.9, 2.7, 2.6,2.3,2.1,1.9},
                {4.4, 3.5, 3.1, 2.9, 2.7, 2.6,2.3,2.1,1.9},
                {3.8,3.0,2.6,2.4,2.2,2.1,1.8,1.5,1},
        };

        double sAD = sum * 3 / (N - d ) ;
        double fP = sAD / sb ;

        // константи використовуються для перевірки : чи не вийде значення f3-1 та f4-1 за межі таблиці,
        // щоб у такому разі присвоїти значення при нескінченності (останній рядок та стовпчик таблиці)


        int constLastRow = 20;
        int constLastColumn = 8;
        if ((f3 -1  < constLastRow) && ( f4-1 < constLastColumn) ){
        if (fP < FisheraTable[f3-1][f4-1]){
            System.out.println("Перевірка за критерієм Фішера");
            System.out.println("Отже, рівняння регресії адекватно оригіналу при рівні значимості 0.05");
        }
        else {
            System.out.println("Отже, рівняння регресії неадекватно оригіналу при рівні значимості 0.05");
        }
        System.out.println();
        }
        else if ((f3 -1  > constLastRow) && ( f4-1 < constLastColumn) ){
            if (fP < FisheraTable[constLastRow][f4-1]){
                System.out.println("Перевірка за критерієм Фішера");
                System.out.println("Отже, рівняння регресії адекватно оригіналу при рівні значимості 0.05");
            }
            else {
                System.out.println("Отже, рівняння регресії неадекватно оригіналу при рівні значимості 0.05");
            }
            System.out.println();
        }
        else if ((f3 -1  < constLastRow) && ( f4-1 > constLastColumn) ){
            if (fP < FisheraTable[f3-1][constLastColumn]){
                System.out.println("Перевірка за критерієм Фішера");
                System.out.println("Отже, рівняння регресії адекватно оригіналу при рівні значимості 0.05");
            }
            else {
                System.out.println("Отже, рівняння регресії неадекватно оригіналу при рівні значимості 0.05");
            }
            System.out.println();
        }
        else if ((f3 -1  > constLastRow) && ( f4-1 > constLastColumn) ){
            if (fP < FisheraTable[constLastRow][constLastColumn]){
                System.out.println("Перевірка за критерієм Фішера");
                System.out.println("Отже, рівняння регресії адекватно оригіналу при рівні значимості 0.05");
            }
            else {
                System.out.println("Отже, рівняння регресії неадекватно оригіналу при рівні значимості 0.05");
            }
            System.out.println();
        }
}
}


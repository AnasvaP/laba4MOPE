// Polyukhovych Nastya IO-82

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class laba3 {

    public static void main(String[] args) {

        double[][] CohrenaTable = {
                {.0,.0,.0,.0,.0,.0,.0,.0,.0,.0},
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

        int x1Min = 10, x2Min = -20, x3Min = 10, x1Max = 50, x2Max = 60, x3Max = 15,
                xAverageMax = (x1Max + x2Max + x3Max) / 3, xAverageMin = (x1Min + x2Min + x3Min) / 3,
                yMax = 200 + xAverageMax, yMin = 200 + xAverageMin , m = 3 , f1 = m-1 , f2 = 4 ,  f3= f1*f2;
        //  y =b0 +b1x1 +b2x2+b3x3

        int[][] matrixForX = {
                {10, -20, 10},
                {10, 60, 15},
                {50, -20, 15},
                {50, 60, 10}
        };

        int[][] matrixForY = new int[4][3];
        int averageY1 = 0 , averageY2 = 0 , averageY3 = 0 , averageY4 = 0 ;

        //матриця для у
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                matrixForY[i][j] = yMin + (int) (Math.random() * (yMax-yMin));
            }
        }
        System.out.println("Матриця Х : "+ Arrays.deepToString(matrixForX));
        System.out.println("Матриця У : "+ Arrays.deepToString(matrixForY));

        for (int j = 0; j < 3; j++) {
            averageY1 += matrixForY[0][j]/3;
            averageY2 += matrixForY[1][j]/3;
            averageY3 += matrixForY[2][j]/3;
            averageY4 += matrixForY[3][j]/3;
        }

        System.out.println("середнє значення функції відгуку для першого рядка = " + averageY1);
        System.out.println("середнє значення функції відгуку для другого рядка = " + averageY2);
        System.out.println("середнє значення функції відгуку для третього рядка = " + averageY3);
        System.out.println("середнє значення функції відгуку для четвертого рядка = " + averageY4);

        double my = (averageY1+averageY2+averageY3+averageY4)/4  , a1 , a2 , a3 , a11 , a22 , a33 , a12, a21 ,
                a13 , a31 , a23 , a32 , mx1 , mx2, mx3, mx1suma = 0.0, mx2suma = 0.0 , mx3suma =0.0;
        for (int i = 0; i < 4; i++) {
            mx1suma += matrixForX[i][0] ;
            mx2suma += matrixForX[i][1] ;
            mx3suma += matrixForX[i][2] ;
        }
        mx1 = mx1suma / 4;
        mx2 = mx2suma / 4;
        mx3 = mx3suma / 4;

        System.out.println("My = " + my);
        System.out.println("Mx1 = " + mx1);
        System.out.println("Mx2 = " + mx2);
        System.out.println("Mx3 = " + mx3);

        a1 = ( averageY1 * matrixForX[0][0] + averageY2 * matrixForX[1][0] + averageY3 * matrixForX[2][0] +averageY4 * matrixForX[3][0] )/ 4;
        a2 = ( averageY1 * matrixForX[0][1] + averageY2 * matrixForX[1][1] + averageY3 * matrixForX[2][1] +averageY4 * matrixForX[3][1] )/ 4;
        a3 = ( averageY1 * matrixForX[0][2] + averageY2 * matrixForX[1][2] + averageY3 * matrixForX[2][2] +averageY4 * matrixForX[3][2] )/ 4;
        a11 = (matrixForX[0][0]*matrixForX[0][0] + matrixForX[1][0]*matrixForX[1][0] + matrixForX[2][0]*matrixForX[2][0] + matrixForX[3][0]*matrixForX[3][0])/4;
        a22 = (matrixForX[0][1]*matrixForX[0][1] + matrixForX[1][1]*matrixForX[1][1] + matrixForX[2][1]*matrixForX[2][1] + matrixForX[3][1]*matrixForX[3][1])/4;
        a33 = (matrixForX[0][2]*matrixForX[0][2] + matrixForX[1][2]*matrixForX[1][2] + matrixForX[2][2]*matrixForX[2][2] + matrixForX[3][2]*matrixForX[3][2])/4;
        a12 = (matrixForX[0][0]*matrixForX[0][1] + matrixForX[1][0]*matrixForX[1][1] + matrixForX[2][0]*matrixForX[2][1] + matrixForX[3][0]*matrixForX[3][1])/4;
        a21 = a12;
        a13 = (matrixForX[0][0]*matrixForX[0][2] + matrixForX[1][0]*matrixForX[1][2] + matrixForX[2][0]*matrixForX[2][2] + matrixForX[3][0]*matrixForX[3][2])/4;
        a31 = a13;
        a23 = (matrixForX[0][1]*matrixForX[0][2] + matrixForX[1][1]*matrixForX[1][2] + matrixForX[2][1]*matrixForX[2][2] + matrixForX[3][1]*matrixForX[3][2])/4;
        a32 = a23;

        double[][] b0Up = {{my,mx1,mx2,mx3},{a1,a11,a12,a13},{a2,a12,a22,a32},{a3,a13,a23,a33}};
        double[][] down = {{1,mx1,mx2,mx3},{mx1,a11,a12,a13},{mx2,a12,a22,a32},{mx3,a13,a23,a33}};
        double[][] b1Up = {{1,my,mx2,mx3},{mx1,a1,a12,a13},{mx2,a2,a22,a32},{mx3,a3,a23,a33}};
        double[][] b2Up = {{1,mx1,my,mx3},{mx1,a11,a1,a13},{mx2,a12,a2,a32},{mx3,a13,a3,a33}};
        double[][] b3Up = {{1,mx1,mx2,my},{mx1,a11,a12,a1},{mx2,a12,a22,a2},{mx3,a13,a23,a3}};

        DeterminantCalc determinantCalcB0UP = new DeterminantCalc(b0Up);
        DeterminantCalc determinantCalcDOWN = new DeterminantCalc(down);
        DeterminantCalc determinantCalcB1UP = new DeterminantCalc(b1Up);
        DeterminantCalc determinantCalcB2UP = new DeterminantCalc(b2Up);
        DeterminantCalc determinantCalcB3UP = new DeterminantCalc(b3Up);

        BigDecimal b0 = determinantCalcB0UP.determinant().divide(determinantCalcDOWN.determinant(), 2, RoundingMode.HALF_UP);
        BigDecimal b1 = determinantCalcB1UP.determinant().divide(determinantCalcDOWN.determinant(), 2, RoundingMode.HALF_UP);
        BigDecimal b2 = determinantCalcB2UP.determinant().divide(determinantCalcDOWN.determinant(), 2, RoundingMode.HALF_UP);
        BigDecimal b3 = determinantCalcB3UP.determinant().divide(determinantCalcDOWN.determinant(), 2, RoundingMode.HALF_UP);

        System.out.println();
        System.out.println("Рівняння регресії : " + "Y = " + b0 + " + " + b1 + "*X1 + " + b2 + "*X2 + "+ b3 + "*X3");
        System.out.println("Перевірка : ");

        //щоб перевірити рівняння використовуючи BigDecimal, для зручності, розділяємо дії на окремі змінні
        BigDecimal averageY1TestPart1 = b0.add(b1.multiply(BigDecimal.valueOf(matrixForX[0][0])));
        BigDecimal averageY1TestPart2 = averageY1TestPart1.add(b2.multiply(BigDecimal.valueOf(matrixForX[0][1])));
        BigDecimal averageY1TestPart3 = averageY1TestPart2.add(b3.multiply(BigDecimal.valueOf(matrixForX[0][2])));

        BigDecimal averageY2TestPart1 = b0.add(b1.multiply(BigDecimal.valueOf(matrixForX[1][0])));
        BigDecimal averageY2TestPart2 = averageY2TestPart1.add(b2.multiply(BigDecimal.valueOf(matrixForX[1][1])));
        BigDecimal averageY2TestPart3 = averageY2TestPart2.add(b3.multiply(BigDecimal.valueOf(matrixForX[1][2])));

        BigDecimal averageY3TestPart1 = b0.add(b1.multiply(BigDecimal.valueOf(matrixForX[2][0])));
        BigDecimal averageY3TestPart2 = averageY3TestPart1.add(b2.multiply(BigDecimal.valueOf(matrixForX[2][1])));
        BigDecimal averageY3TestPart3 = averageY3TestPart2.add(b3.multiply(BigDecimal.valueOf(matrixForX[2][2])));

        BigDecimal averageY4TestPart1 = b0.add(b1.multiply(BigDecimal.valueOf(matrixForX[3][0])));
        BigDecimal averageY4TestPart2 = averageY4TestPart1.add(b2.multiply(BigDecimal.valueOf(matrixForX[3][1])));
        BigDecimal averageY4TestPart3 = averageY4TestPart2.add(b3.multiply(BigDecimal.valueOf(matrixForX[3][2])));

        System.out.println("Y1 test = "+averageY1TestPart3 + "  /  Y1 = " + averageY1);
        System.out.println("Y2 test = "+averageY2TestPart3 + "  /  Y2 = " + averageY2);
        System.out.println("Y3 test = "+averageY3TestPart3 + "  /  Y3 = " + averageY3);
        System.out.println("Y4 test = "+averageY4TestPart3 + "  /  Y4 = " + averageY4);

        /**                    Перевірка однорідності дисперсії за критерієм Кохрена                                          */

        int[][] mainMatrix = {
                {1, -1, -1, -1},
                {1, -1, 1, 1},
                {1, 1, -1, 1},
                {1, 1, 1, -1}};

        // дисперсія
        double dispersion1 = 0 , dispersion2 = 0, dispersion3 = 0, dispersion4 = 0 ;
        for (int j=0; j<3 ; j++){
            dispersion1 += (Math.pow((matrixForY[0][j] - averageY1),2))/3;
            dispersion2 += (Math.pow((matrixForY[1][j] - averageY2),2))/3;
            dispersion3 += (Math.pow((matrixForY[2][j] - averageY3),2))/3;
            dispersion4 += (Math.pow((matrixForY[3][j] - averageY4),2))/3;
        }
        System.out.println();
        System.out.println("дисперсія 1 = " + dispersion1);
        System.out.println("дисперсія 2 = " + dispersion2);
        System.out.println("дисперсія 3 = " + dispersion3);
        System.out.println("дисперсія 4 = " + dispersion4);

        int numberOfY = 3;
        double  gp = Math.max(Math.max(dispersion1,dispersion2),Math.max(dispersion3,dispersion4))/ (dispersion1+dispersion2+dispersion3+dispersion4);
        if ( gp > CohrenaTable[f2-1][f1-1] ){

            System.out.println("Gp = "+ gp + " >   " + CohrenaTable[f2-1][f1-1]);
            System.out.println();
            System.out.println("Збільшимо кількість дослідів і повторимо перевірку");
            numberOfY +=1;
            int[][] matrixForYNew = new int[4][numberOfY];
            System.out.println("Кількість у = " + numberOfY);

            //матриця для нового у
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < numberOfY; j++) {
                    matrixForYNew[i][j] = yMin + (int) (Math.random() * (yMax-yMin));
                }
            }

            for (int j = 0; j < numberOfY; j++) {
                averageY1 += matrixForYNew[0][j]/numberOfY; averageY2 += matrixForYNew[1][j]/numberOfY; averageY3 += matrixForYNew[2][j]/numberOfY; averageY4 += matrixForYNew[3][j]/numberOfY;
            }

            double dispersionNew1 = 0 , dispersionNew2 = 0, dispersionNew3 = 0, dispersionNew4 = 0 ;
            for (int j=0; j<numberOfY ; j++){
                dispersionNew1 += (Math.pow((matrixForYNew[0][j] - averageY1),2))/4;
                dispersionNew2 += (Math.pow((matrixForYNew[1][j] - averageY2),2))/4;
                dispersionNew3 += (Math.pow((matrixForYNew[2][j] - averageY3),2))/4;
                dispersionNew4 += (Math.pow((matrixForYNew[3][j] - averageY4),2))/4;
            }

            System.out.println();
            System.out.println("дисперсія 1 = " + dispersionNew1);
            System.out.println("дисперсія 2 = " + dispersionNew2);
            System.out.println("дисперсія 3 = " + dispersionNew3);
            System.out.println("дисперсія 4 = " + dispersionNew4);
            double  gpNew = Math.max(Math.max(dispersionNew1,dispersionNew2),Math.max(dispersionNew3,dispersionNew4))/ (dispersionNew1+dispersionNew2+dispersionNew3+dispersionNew4);
            System.out.println("GpNew = "+ gpNew + " < " + CohrenaTable[f2-2][f1-1]);

        }
        else{
            System.out.println(); System.out.println("Gp = "+ gp + " < " + CohrenaTable[f2-1][f1-1]);
        }


        /**                   Далі оцінимо значимість коефіцієнтів регресії згідно критерію Стьюдента                                         */
        /**                                              Критерій Фішера                                             */



        double sb = (dispersion1+dispersion2+dispersion3+dispersion4) /4,
         t = StudentaTable[f3-1],
         sBetta = Math.sqrt(sb/ (4 * m)) ,
         betta0 = (averageY1*mainMatrix[0][0] + averageY2 * mainMatrix[0][1] + averageY3 * mainMatrix[0][2] + averageY4* mainMatrix[0][3] )/4,
         betta1 = (averageY1*mainMatrix[1][0] + averageY2 * mainMatrix[1][1] + averageY3 * mainMatrix[1][2] + averageY4* mainMatrix[1][3] )/4,
         betta2 = (averageY1*mainMatrix[2][0] + averageY2 * mainMatrix[2][1] + averageY3 * mainMatrix[2][2] + averageY4* mainMatrix[2][3] )/4,
         betta3 = (averageY1*mainMatrix[3][0] + averageY2 * mainMatrix[3][1] + averageY3 * mainMatrix[3][2] + averageY4* mainMatrix[3][3] )/4,
         t0 = Math.abs(betta0)/sBetta,
         t1 = Math.abs(betta1)/sBetta,
         t2 = Math.abs(betta2)/sBetta,
         t3 = Math.abs(betta3)/sBetta;
        int d = 4 ;
        if (t0 < t){
            System.out.println("Із перевірки виходить , що коефіцієнт b0 незначимий   " + t0 + " < " + t);
            d -= 1 ;
        }
        else{ System.out.println("Із перевірки виходить , що коефіцієнт b0 значимий   " + t0 + " > " + t); }
        if (t1 < t){
            System.out.println("Із перевірки виходить , що коефіцієнт b1 незначимий  "  + t1 + " < " + t);
            d -= 1 ;
        }
        else{ System.out.println("Із перевірки виходить , що коефіцієнт b1 значимий  "+ t1 + " > " + t); }
        if (t2 < t){
            System.out.println("Із перевірки виходить , що коефіцієнт b2 незначимий  "  + t2 + " < " + t);
            d -= 1 ;
        }
        else{ System.out.println("Із перевірки виходить , що коефіцієнт b2 значимий   "+ t2 + " > " + t); }
        if (t3 < t){
            System.out.println("Із перевірки виходить , що коефіцієнт b3 незначимий  "  + t3 + " < " + t);
            d -= 1 ;
        }
        else{ System.out.println("Із перевірки виходить , що коефіцієнт b3 значимий  "+ t3 + " > " + t); }

        int f4 = 4 - d ;
        if (f4 == 0) {
            System.out.println("Неможливо порахувати критерій Фішера , оскільки f4 = 0 ");
        }
        else {

            if (d == 4) {
                System.out.println("Рівняння регресії залишається без змін");
            } else if (d == 3) {
                System.out.println("Рівняння регресії : "
                        + "Y = " + b1 + "*X1 + " + b2 + "*X2 + " + b3 + "*X3");
                averageY1TestPart1 = b1.multiply(BigDecimal.valueOf(matrixForX[0][0]));
                averageY1TestPart2 = averageY1TestPart1.add(b2.multiply(BigDecimal.valueOf(matrixForX[0][1])));
                averageY1TestPart3 = averageY1TestPart2.add(b3.multiply(BigDecimal.valueOf(matrixForX[0][2])));

                averageY2TestPart1 = b1.multiply(BigDecimal.valueOf(matrixForX[1][0]));
                averageY2TestPart2 = averageY2TestPart1.add(b2.multiply(BigDecimal.valueOf(matrixForX[1][1])));
                averageY2TestPart3 = averageY2TestPart2.add(b3.multiply(BigDecimal.valueOf(matrixForX[1][2])));

                averageY3TestPart1 = b1.multiply(BigDecimal.valueOf(matrixForX[2][0]));
                averageY3TestPart2 = averageY3TestPart1.add(b2.multiply(BigDecimal.valueOf(matrixForX[2][1])));
                averageY3TestPart3 = averageY3TestPart2.add(b3.multiply(BigDecimal.valueOf(matrixForX[2][2])));

                averageY4TestPart1 = b1.multiply(BigDecimal.valueOf(matrixForX[3][0]));
                averageY4TestPart2 = averageY4TestPart1.add(b2.multiply(BigDecimal.valueOf(matrixForX[3][1])));
                averageY4TestPart3 = averageY4TestPart2.add(b3.multiply(BigDecimal.valueOf(matrixForX[3][2])));

                BigDecimal part1 = (averageY1TestPart3.subtract(BigDecimal.valueOf(averageY1))).multiply(averageY1TestPart3.subtract(BigDecimal.valueOf(averageY1)));
                BigDecimal part2 = (averageY2TestPart3.subtract(BigDecimal.valueOf(averageY2))).multiply(averageY2TestPart3.subtract(BigDecimal.valueOf(averageY2)));
                BigDecimal part3 = (averageY3TestPart3.subtract(BigDecimal.valueOf(averageY3))).multiply(averageY3TestPart3.subtract(BigDecimal.valueOf(averageY3)));
                BigDecimal part4 = (averageY4TestPart3.subtract(BigDecimal.valueOf(averageY4))).multiply(averageY4TestPart3.subtract(BigDecimal.valueOf(averageY4)));
                BigDecimal sum1 = ((part1.add(part2)).add(part3)).add(part4);
                FisheraMethod(sum1,d,sb,f3,f4);

            } else if (d == 2) {
                System.out.println("Рівняння регресії : "
                        + "Y = " + b2 + "*X2 + " + b3 + "*X3");
                averageY1TestPart2 = b2.multiply(BigDecimal.valueOf(matrixForX[0][1]));
                averageY1TestPart3 = averageY1TestPart2.add(b3.multiply(BigDecimal.valueOf(matrixForX[0][2])));
                averageY2TestPart2 = b2.multiply(BigDecimal.valueOf(matrixForX[1][1]));
                averageY2TestPart3 = averageY2TestPart2.add(b3.multiply(BigDecimal.valueOf(matrixForX[1][2])));
                averageY3TestPart2 = b2.multiply(BigDecimal.valueOf(matrixForX[2][1]));
                averageY3TestPart3 = averageY3TestPart2.add(b3.multiply(BigDecimal.valueOf(matrixForX[2][2])));
                averageY4TestPart2 = b2.multiply(BigDecimal.valueOf(matrixForX[3][1]));
                averageY4TestPart3 = averageY4TestPart2.add(b3.multiply(BigDecimal.valueOf(matrixForX[3][2])));

                BigDecimal part1 = (averageY1TestPart3.subtract(BigDecimal.valueOf(averageY1))).multiply(averageY1TestPart3.subtract(BigDecimal.valueOf(averageY1)));
                BigDecimal part2 = (averageY2TestPart3.subtract(BigDecimal.valueOf(averageY2))).multiply(averageY2TestPart3.subtract(BigDecimal.valueOf(averageY2)));
                BigDecimal part3 = (averageY3TestPart3.subtract(BigDecimal.valueOf(averageY3))).multiply(averageY3TestPart3.subtract(BigDecimal.valueOf(averageY3)));
                BigDecimal part4 = (averageY4TestPart3.subtract(BigDecimal.valueOf(averageY4))).multiply(averageY4TestPart3.subtract(BigDecimal.valueOf(averageY4)));
                BigDecimal sum2 = ((part1.add(part2)).add(part3)).add(part4);
                FisheraMethod(sum2,d,sb,f3,f4);
            } else if (d == 1) {
                System.out.println("Рівняння регресії : "
                        + "Y = " + b3 + "*X3");

                averageY1TestPart3 = b3.multiply(BigDecimal.valueOf(matrixForX[0][2]));
                averageY2TestPart3 = b3.multiply(BigDecimal.valueOf(matrixForX[1][2]));
                averageY3TestPart3 = b3.multiply(BigDecimal.valueOf(matrixForX[2][2]));
                averageY4TestPart3 = b3.multiply(BigDecimal.valueOf(matrixForX[3][2]));

                BigDecimal part1 = (averageY1TestPart3.subtract(BigDecimal.valueOf(averageY1))).multiply(averageY1TestPart3.subtract(BigDecimal.valueOf(averageY1)));
                BigDecimal part2 = (averageY2TestPart3.subtract(BigDecimal.valueOf(averageY2))).multiply(averageY2TestPart3.subtract(BigDecimal.valueOf(averageY2)));
                BigDecimal part3 = (averageY3TestPart3.subtract(BigDecimal.valueOf(averageY3))).multiply(averageY3TestPart3.subtract(BigDecimal.valueOf(averageY3)));
                BigDecimal part4 = (averageY4TestPart3.subtract(BigDecimal.valueOf(averageY4))).multiply(averageY4TestPart3.subtract(BigDecimal.valueOf(averageY4)));
                BigDecimal sum3 = ((part1.add(part2)).add(part3)).add(part4);
                FisheraMethod(sum3,d,sb,f3,f4);
            }
        }
    }

    public static void FisheraMethod (BigDecimal sum , int d , double sb , int f3 , int f4){

        double[][] FisheraTable = {
                {164.4, 199.5, 215.7, 224.6, 230.2, 234}, {18.5, 19.2, 19.2, 19.3, 19.3, 19.3},
                {10.1, 9.6, 9.3, 9.1, 9, 8.9}, {7.7, 6.9, 6.6, 6.4, 6.3, 6.2},
                {6.6, 5.8, 5.4, 5.2, 5.1, 5}, {6, 5.1, 4.8, 4.5, 4.4, 4.3},
                {5.5, 4.7, 4.4, 4.1, 4, 3.9}, {5.3, 4.5, 4.1, 3.8, 3.7, 3.6},
                {5.1, 4.3, 3.9, 3.6, 3.5, 3.4}, {5, 4.1, 3.7, 3.5, 3.3, 3.2},
                {4.8, 4, 3.6, 3.4, 3.2, 3.1}, {4.8, 3.9, 3.5, 3.3, 3.1, 3},
                {4.7, 3.8, 3.4, 3.2, 3, 2.9}, {4.6, 3.7, 3.3, 3.1, 3, 2.9},
                {4.5, 3.7, 3.3, 3.1, 2.9, 2.8}, {4.5, 3.6, 3.2, 3, 2.9, 2.7},
                {4.5, 3.6, 3.2, 3, 2.8, 2.7}, {4.4, 3.6, 3.2, 2.9, 2.8, 2.7},
                {4.4, 3.5, 3.1, 2.9, 2.7, 2.6}, {4.4, 3.5, 3.1, 2.9, 2.7, 2.6},
        };

        double sAD = sum.intValue() * 3 / (4 - d ) ;
        double fP = sAD / sb ;
        if (fP < FisheraTable[f3-1][f4-1]){
            System.out.println("Отже, рівняння регресії адекватно оригіналу при рівні значимості 0.05");
        }
        else {
            System.out.println("Отже, рівняння регресії неадекватно оригіналу при рівні значимості 0.05");
        }
        System.out.println();
    }

}


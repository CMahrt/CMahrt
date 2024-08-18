package de.cm.mandelproto.math;

public class MandelbrotPointMap extends IterationMap {
    double step ;
    double left ;
    double top ;

    public MandelbrotPointMap(ComplexNumber center, double width, double height, int stepOnWidth, int maxIterations) {
        super(center, width, height, stepOnWidth, maxIterations);
    }

    @Override
    public void init() {
        step = width / stepOnWidth;
        left = center.getReal() - width / 2;
        top = center.getImag() + height / 2;
        for (int i = 0; i < stepOnWidth; i++)
            for (int j = 0; j < stepOnHeight; j++) {
                points[i][j] =
                        new MandelbrotPoint(
                                new ComplexNumber(
                                        left + i * step,
                                        top - j * step
                                )
                        );
            }

        System.out.println("stepOnHeight = " + stepOnHeight);
        System.out.println("stepOnWidth = " + stepOnWidth);
        System.out.println("top , bottom = " + top + "," + (top - stepOnHeight * step));
        System.out.println("left , right = " + left + "," + (left + stepOnWidth * step));
    }

    @Override
    public ComplexNumber getComplexNumberForCoordinate(int x, int y) {
        return new ComplexNumber(left + x * step, top - y * step);
    }
}

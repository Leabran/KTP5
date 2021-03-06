import java.awt.geom.Rectangle2D;

/** Этот класс предоставляет общий интерфейс и операции для генераторов фракталов **/
public abstract class FractalGenerator {

    public static double getCoord(double rangeMin, double rangeMax,
        int size, int coord) {

        assert size > 0;
        assert coord >= 0 && coord < size;

        double range = rangeMax - rangeMin;
        return rangeMin + (range * (double) coord / (double) size);
    }


    /** Устанавливает указанный прямоугольник, чтобы содержать начальный диапазон **/
    public abstract void getInitialRange(Rectangle2D.Double range);


    /** Обновляет текущий диапазон с центром в указанных координатах **/
    public void recenterAndZoomRange(Rectangle2D.Double range,
        double centerX, double centerY, double scale) {

        double newWidth = range.width * scale;
        double newHeight = range.height * scale;

        range.x = centerX - newWidth / 2;
        range.y = centerY - newHeight / 2;
        range.width = newWidth;
        range.height = newHeight;
    }

    public abstract int numIterations(double x, double y);
	
	public String toString() {
		return "Fractal Generator";
	}
}

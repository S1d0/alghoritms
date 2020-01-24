# alghoritms
This repo is just playground for my learning with algorithms and data structures


# Task 1: 
Find all lines that contains more than 3 points and return pair that cross each over with angel equal to 90
Line equitatation y = ax + b  
Cross equitation a1 * a2 = -1 

#Move this to program: 

import spock.lang.Specification

import java.math.RoundingMode

class SearchLines extends Specification {


    def 'should get a and b for two Points from getFx'() {
        expect:
        LineFx.of(p1, p2) == fx

        where:
        p1                      | p2                    | fx
        new Point(1, 1)   | new Point(2, 2) | new LineFx(1, 0)
        new Point(2, 1)   | new Point(1, 4) | new LineFx(-3, 7)
        Point.of(-1, 1)   | Point.of(-2, 2) | new LineFx(-1, 0)
    }


    def 'should get info is point fit to line'() {
        given:
        LineFx fx = new LineFx(-3, 7)

        expect:
        fx.isPointInLine(new Point(2, 1))
        fx.isPointInLine(new Point(1, 4))


    }

    def 'should find all lines'() {
        given:
        Point[] points = [
                Point.of(1, 1), Point.of(2, 2), Point.of(3, 3),Point.of(-5,-5),
                Point.of(-1, 1), Point.of(-2, 2), Point.of(-3, 3), Point.of(5,5), Point.of(2,-2)
        ]

        expect:
        SearchAlg.getLineSegments(points).size() == 2

    }
}


class SearchAlg {


    static List<LineSegment> getLineSegments(Point[] points) {
        Map<LineFx, LineSegment> map = new HashMap<>()

        for (int i1 = 0; i1 < points.length; i1++) {
            for (int i2 = i1 + 1; i2 < points.length; i2++) {
                Point p1 = points[i1]
                Point p2 = points[i2]

                LineSegment ls = new LineSegment(p1, p2)

                if (!map.containsKey(ls.fun)) {
                    map.put(ls.fun, ls)

                    int i3 = 0
                    while (i3 <= points.length - 1) {

                        Point p3 = points[i3]
                        if (p3 != p1 && p3 != p2) {
                            if (ls.isInLine(p3)) {
                                ls.addPoint(p3)
                            }
                        }
                        i3++
                    }
                }
            }
        }


        Map<LineFx, LineSegment> reduceMap = map.findAll {it -> it.value.size() > 4}

        return reduceMap.size()
    }


}

class Point implements Comparable<Point>{
    int x
    int y

    Point(int x, int y) {
        this.x = x
        this.y = y
    }

    static Point of(int x, int y) {
        return new Point(x, y)
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Point point = (Point) o

        if (x != point.x) return false
        if (y != point.y) return false

        return true
    }

    int hashCode() {
        int result
        result = x
        result = 31 * result + y
        return result
    }

    @Override
    int compareTo(Point point) {
        return this.x - point.x
    }
}

class LineFx {
    Double a
    Double b

    LineFx(Double a, Double b) {
        this.a = a
        this.b = b
    }

    static LineFx of(Point p1, Point p2) {
        Double a = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX())
        Double b = p1.getY() - (p1.getX() * a)

        a = round(a, 2)
        b = round(b, 2)
        return new LineFx(a, b)
    }

    boolean isPointInLine(Point p) {
        return b == p.getY() - a * p.getX()
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        LineFx lineFx = (LineFx) o

        if (a != lineFx.a) return false
        if (b != lineFx.b) return false

        return true
    }

    int hashCode() {
        int result
        result = (a != null ? a.hashCode() : 0)
        result = 31 * result + (b != null ? b.hashCode() : 0)
        return result
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException()
        BigDecimal bd = new BigDecimal(Double.toString(value))
        bd = bd.setScale(places, RoundingMode.HALF_DOWN)
        return bd.doubleValue()
    }
}

class LineSegment {
    private Set<Point> points = new TreeSet<>()
    public final LineFx fun

    LineSegment(Point p1, Point p2) {
        points.add(p1)
        points.add(p2)
        fun = LineFx.of(p1, p2)
    }

    boolean isInLine(Point p) {
        return fun.isPointInLine(p)
    }

    int getLineLength() {
        return points.size()
    }

    void addPoint(Point p){
        points.add(p)
    }

    int size(){
        return points.size()
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        LineSegment that = (LineSegment) o

        if (fun != that.fun) return false
        if (points != that.points) return false

        return true
    }

    int hashCode() {
        int result
        result = (points != null ? points.hashCode() : 0)
        result = 31 * result + (fun != null ? fun.hashCode() : 0)
        return result
    }
}

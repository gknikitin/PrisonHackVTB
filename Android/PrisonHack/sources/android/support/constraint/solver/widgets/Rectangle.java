package android.support.constraint.solver.widgets;

public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x */
    public int f10x;

    /* renamed from: y */
    public int f11y;

    public void setBounds(int i, int i2, int i3, int i4) {
        this.f10x = i;
        this.f11y = i2;
        this.width = i3;
        this.height = i4;
    }

    /* access modifiers changed from: package-private */
    public void grow(int i, int i2) {
        this.f10x -= i;
        this.f11y -= i2;
        this.width += i * 2;
        this.height += i2 * 2;
    }

    /* access modifiers changed from: package-private */
    public boolean intersects(Rectangle rectangle) {
        return this.f10x >= rectangle.f10x && this.f10x < rectangle.f10x + rectangle.width && this.f11y >= rectangle.f11y && this.f11y < rectangle.f11y + rectangle.height;
    }

    public boolean contains(int i, int i2) {
        return i >= this.f10x && i < this.f10x + this.width && i2 >= this.f11y && i2 < this.f11y + this.height;
    }

    public int getCenterX() {
        return (this.f10x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f11y + this.height) / 2;
    }
}

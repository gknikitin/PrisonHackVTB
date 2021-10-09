package com.github.mikephil.charting.matrix;

public final class Vector3 {
    public static final Vector3 UNIT_X = new Vector3(1.0f, 0.0f, 0.0f);
    public static final Vector3 UNIT_Y = new Vector3(0.0f, 1.0f, 0.0f);
    public static final Vector3 UNIT_Z = new Vector3(0.0f, 0.0f, 1.0f);
    public static final Vector3 ZERO = new Vector3(0.0f, 0.0f, 0.0f);

    /* renamed from: x */
    public float f60x;

    /* renamed from: y */
    public float f61y;

    /* renamed from: z */
    public float f62z;

    public Vector3() {
    }

    public Vector3(float[] fArr) {
        set(fArr[0], fArr[1], fArr[2]);
    }

    public Vector3(float f, float f2, float f3) {
        set(f, f2, f3);
    }

    public Vector3(Vector3 vector3) {
        set(vector3);
    }

    public final void add(Vector3 vector3) {
        this.f60x += vector3.f60x;
        this.f61y += vector3.f61y;
        this.f62z += vector3.f62z;
    }

    public final void add(float f, float f2, float f3) {
        this.f60x += f;
        this.f61y += f2;
        this.f62z += f3;
    }

    public final void subtract(Vector3 vector3) {
        this.f60x -= vector3.f60x;
        this.f61y -= vector3.f61y;
        this.f62z -= vector3.f62z;
    }

    public final void subtractMultiple(Vector3 vector3, float f) {
        this.f60x -= vector3.f60x * f;
        this.f61y -= vector3.f61y * f;
        this.f62z -= vector3.f62z * f;
    }

    public final void multiply(float f) {
        this.f60x *= f;
        this.f61y *= f;
        this.f62z *= f;
    }

    public final void multiply(Vector3 vector3) {
        this.f60x *= vector3.f60x;
        this.f61y *= vector3.f61y;
        this.f62z *= vector3.f62z;
    }

    public final void divide(float f) {
        if (f != 0.0f) {
            this.f60x /= f;
            this.f61y /= f;
            this.f62z /= f;
        }
    }

    public final void set(Vector3 vector3) {
        this.f60x = vector3.f60x;
        this.f61y = vector3.f61y;
        this.f62z = vector3.f62z;
    }

    public final void set(float f, float f2, float f3) {
        this.f60x = f;
        this.f61y = f2;
        this.f62z = f3;
    }

    public final float dot(Vector3 vector3) {
        return (this.f60x * vector3.f60x) + (this.f61y * vector3.f61y) + (this.f62z * vector3.f62z);
    }

    public final Vector3 cross(Vector3 vector3) {
        return new Vector3((this.f61y * vector3.f62z) - (this.f62z * vector3.f61y), (this.f62z * vector3.f60x) - (this.f60x * vector3.f62z), (this.f60x * vector3.f61y) - (this.f61y * vector3.f60x));
    }

    public final float length() {
        return (float) Math.sqrt((double) length2());
    }

    public final float length2() {
        return (this.f60x * this.f60x) + (this.f61y * this.f61y) + (this.f62z * this.f62z);
    }

    public final float distance2(Vector3 vector3) {
        float f = this.f60x - vector3.f60x;
        float f2 = this.f61y - vector3.f61y;
        float f3 = this.f62z - vector3.f62z;
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    public final float normalize() {
        float length = length();
        if (length != 0.0f) {
            this.f60x /= length;
            this.f61y /= length;
            this.f62z /= length;
        }
        return length;
    }

    public final void zero() {
        set(0.0f, 0.0f, 0.0f);
    }

    public final boolean pointsInSameDirection(Vector3 vector3) {
        return dot(vector3) > 0.0f;
    }
}

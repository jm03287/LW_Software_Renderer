public class Triangle {

	private hVector3D vertex1, vertex2, vertex3;
	
	public Triangle(float[] v1, float[] v2, float[] v3) {
		this.vertex1 = new hVector3D(new float[]{v1[0], v1[1], v1[2], 1f});
		this.vertex2 = new hVector3D(new float[]{v2[0], v2[1], v2[2], 1f});
		this.vertex3 = new hVector3D(new float[]{v3[0], v3[1], v3[2], 1f});
	}

	public hVector3D getVertex1() {
		return vertex1;
	}

	public hVector3D getVertex2() {
		return vertex2;
	}

	public hVector3D getVertex3() {
		return vertex3;
	}

}

import java.lang.Math;

public class hVector3D {
	private final float HWCOORD;
	private final float XCOORD;
	private final float YCOORD;
	private final float ZCOORD;
	
	public hVector3D(float[] hVector3DAtt) {
		this.XCOORD = hVector3DAtt[0];
		this.YCOORD = hVector3DAtt[1];
		this.ZCOORD = hVector3DAtt[2];
		this.HWCOORD = hVector3DAtt[3];
	}

	public float getMagnitude() {
		float length = (float) Math.sqrt((this.getXCOORD()*this.getXCOORD())+(this.getYCOORD()*this.getYCOORD())+(this.getZCOORD()*this.getZCOORD()));
		return length;
	}
	
	public hVector3D normalizedhVector3D() {
		float[] normalizedhVector3DArr = {this.getXCOORD()/this.getMagnitude(), this.getYCOORD()/this.getMagnitude(), this.getZCOORD()/this.getMagnitude()};
		return new hVector3D(normalizedhVector3DArr);
	}
	
	public float getXCOORD() {
		return XCOORD;
	}

	public float getYCOORD() {
		return YCOORD;
	}

	public float getZCOORD() {
		return ZCOORD;
	}

	public float getHWCOORD() {
		return HWCOORD;
	}
	
}
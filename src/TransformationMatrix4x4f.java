public class TransformationMatrix4x4f {
	
	private final float ENTRY0_0;
	private final float ENTRY0_1;
	private final float ENTRY0_2;
	private final float ENTRY0_3;
	private final float ENTRY1_0;
	private final float ENTRY1_1;
	private final float ENTRY1_2;
	private final float ENTRY1_3;
	private final float ENTRY2_0;
	private final float ENTRY2_1;
	private final float ENTRY2_2;
	private final float ENTRY2_3;
	private final float ENTRY3_0;
	private final float ENTRY3_1;
	private final float ENTRY3_2;
	private final float ENTRY3_3;
	
	public TransformationMatrix4x4f(float[][] entries) {
		this.ENTRY0_0 = entries[0][0];
		this.ENTRY0_1 = entries[0][1];
		this.ENTRY0_2 = entries[0][2];
		this.ENTRY0_3 = entries[0][3];
		this.ENTRY1_0 = entries[1][0];
		this.ENTRY1_1 = entries[1][1];
		this.ENTRY1_2 = entries[1][2];
		this.ENTRY1_3 = entries[1][3];
		this.ENTRY2_0 = entries[2][0];
		this.ENTRY2_1 = entries[2][1];
		this.ENTRY2_2 = entries[2][2];
		this.ENTRY2_3 = entries[2][3];
		this.ENTRY3_0 = entries[3][0];
		this.ENTRY3_1 = entries[3][1];
		this.ENTRY3_2 = entries[3][2];
		this.ENTRY3_3 = entries[3][3];
	}
	
	public static TransformationMatrix4x4f transformMatrix4x4(TransformationMatrix4x4f transformationMatrix4x4, TransformationMatrix4x4f inputSeedMatrix4x4) {
		float[][] resultantMatrix = {{inputSeedMatrix4x4.getENTRY0_0()*transformationMatrix4x4.getENTRY0_0() + inputSeedMatrix4x4.getENTRY1_0()*transformationMatrix4x4.getENTRY0_1() + inputSeedMatrix4x4.getENTRY2_0()*transformationMatrix4x4.getENTRY0_2() + inputSeedMatrix4x4.getENTRY3_0()*transformationMatrix4x4.getENTRY0_3(),
									 inputSeedMatrix4x4.getENTRY0_1()*transformationMatrix4x4.getENTRY0_0() + inputSeedMatrix4x4.getENTRY1_1()*transformationMatrix4x4.getENTRY0_1() + inputSeedMatrix4x4.getENTRY2_1()*transformationMatrix4x4.getENTRY0_2() + inputSeedMatrix4x4.getENTRY3_1()*transformationMatrix4x4.getENTRY0_3(),
									 inputSeedMatrix4x4.getENTRY0_2()*transformationMatrix4x4.getENTRY0_0() + inputSeedMatrix4x4.getENTRY1_2()*transformationMatrix4x4.getENTRY0_1() + inputSeedMatrix4x4.getENTRY2_2()*transformationMatrix4x4.getENTRY0_2() + inputSeedMatrix4x4.getENTRY3_2()*transformationMatrix4x4.getENTRY0_3(),
									 inputSeedMatrix4x4.getENTRY0_3()*transformationMatrix4x4.getENTRY0_0() + inputSeedMatrix4x4.getENTRY1_3()*transformationMatrix4x4.getENTRY0_1() + inputSeedMatrix4x4.getENTRY2_3()*transformationMatrix4x4.getENTRY0_2() + inputSeedMatrix4x4.getENTRY3_3()*transformationMatrix4x4.getENTRY0_3()},
									 {inputSeedMatrix4x4.getENTRY0_0()*transformationMatrix4x4.getENTRY1_0() + inputSeedMatrix4x4.getENTRY1_0()*transformationMatrix4x4.getENTRY1_1() + inputSeedMatrix4x4.getENTRY2_0()*transformationMatrix4x4.getENTRY1_2() + inputSeedMatrix4x4.getENTRY3_0()*transformationMatrix4x4.getENTRY1_3(),
									 inputSeedMatrix4x4.getENTRY0_1()*transformationMatrix4x4.getENTRY1_0() + inputSeedMatrix4x4.getENTRY1_1()*transformationMatrix4x4.getENTRY1_1() + inputSeedMatrix4x4.getENTRY2_1()*transformationMatrix4x4.getENTRY1_2() + inputSeedMatrix4x4.getENTRY3_1()*transformationMatrix4x4.getENTRY1_3(),
									 inputSeedMatrix4x4.getENTRY0_2()*transformationMatrix4x4.getENTRY1_0() + inputSeedMatrix4x4.getENTRY1_2()*transformationMatrix4x4.getENTRY1_1() + inputSeedMatrix4x4.getENTRY2_2()*transformationMatrix4x4.getENTRY1_2() + inputSeedMatrix4x4.getENTRY3_2()*transformationMatrix4x4.getENTRY1_3(),
									 inputSeedMatrix4x4.getENTRY0_3()*transformationMatrix4x4.getENTRY1_0() + inputSeedMatrix4x4.getENTRY1_3()*transformationMatrix4x4.getENTRY1_1() + inputSeedMatrix4x4.getENTRY2_3()*transformationMatrix4x4.getENTRY1_2() + inputSeedMatrix4x4.getENTRY3_3()*transformationMatrix4x4.getENTRY1_3()},
									 {inputSeedMatrix4x4.getENTRY0_0()*transformationMatrix4x4.getENTRY2_0() + inputSeedMatrix4x4.getENTRY1_0()*transformationMatrix4x4.getENTRY2_1() + inputSeedMatrix4x4.getENTRY2_0()*transformationMatrix4x4.getENTRY2_2() + inputSeedMatrix4x4.getENTRY3_0()*transformationMatrix4x4.getENTRY2_3(),
									 inputSeedMatrix4x4.getENTRY0_1()*transformationMatrix4x4.getENTRY2_0() + inputSeedMatrix4x4.getENTRY1_1()*transformationMatrix4x4.getENTRY2_1() + inputSeedMatrix4x4.getENTRY2_1()*transformationMatrix4x4.getENTRY2_2() + inputSeedMatrix4x4.getENTRY3_1()*transformationMatrix4x4.getENTRY2_3(),
									 inputSeedMatrix4x4.getENTRY0_2()*transformationMatrix4x4.getENTRY2_0() + inputSeedMatrix4x4.getENTRY1_2()*transformationMatrix4x4.getENTRY2_1() + inputSeedMatrix4x4.getENTRY2_2()*transformationMatrix4x4.getENTRY2_2() + inputSeedMatrix4x4.getENTRY3_2()*transformationMatrix4x4.getENTRY2_3(),
									 inputSeedMatrix4x4.getENTRY0_3()*transformationMatrix4x4.getENTRY2_0() + inputSeedMatrix4x4.getENTRY1_3()*transformationMatrix4x4.getENTRY2_1() + inputSeedMatrix4x4.getENTRY2_3()*transformationMatrix4x4.getENTRY2_2() + inputSeedMatrix4x4.getENTRY3_3()*transformationMatrix4x4.getENTRY2_3()},
									 {inputSeedMatrix4x4.getENTRY0_0()*transformationMatrix4x4.getENTRY3_0() + inputSeedMatrix4x4.getENTRY1_0()*transformationMatrix4x4.getENTRY3_1() + inputSeedMatrix4x4.getENTRY2_0()*transformationMatrix4x4.getENTRY3_2() + inputSeedMatrix4x4.getENTRY3_0()*transformationMatrix4x4.getENTRY3_3(),
									 inputSeedMatrix4x4.getENTRY0_1()*transformationMatrix4x4.getENTRY3_0() + inputSeedMatrix4x4.getENTRY1_1()*transformationMatrix4x4.getENTRY3_1() + inputSeedMatrix4x4.getENTRY2_1()*transformationMatrix4x4.getENTRY3_2() + inputSeedMatrix4x4.getENTRY3_1()*transformationMatrix4x4.getENTRY3_3(),
									 inputSeedMatrix4x4.getENTRY0_2()*transformationMatrix4x4.getENTRY3_0() + inputSeedMatrix4x4.getENTRY1_2()*transformationMatrix4x4.getENTRY3_1() + inputSeedMatrix4x4.getENTRY2_2()*transformationMatrix4x4.getENTRY3_2() + inputSeedMatrix4x4.getENTRY3_2()*transformationMatrix4x4.getENTRY3_3(),
									 inputSeedMatrix4x4.getENTRY0_3()*transformationMatrix4x4.getENTRY3_0() + inputSeedMatrix4x4.getENTRY1_3()*transformationMatrix4x4.getENTRY3_1() + inputSeedMatrix4x4.getENTRY2_3()*transformationMatrix4x4.getENTRY3_2() + inputSeedMatrix4x4.getENTRY3_3()*transformationMatrix4x4.getENTRY3_3()}};
		return new TransformationMatrix4x4f(resultantMatrix);
	}
	
	
	public static void main(String[] args) {
		//TransformationMatrix4x4f defaultMat = new TransformationMatrix4x4f().modelViewCoordsMatrixs4x4(1.0f, -0.5f, -0.5f, 45.0f, 45.0f, 0.0f);
		//TransformationMatrix4x4f defaultMat = new TransformationMatrix4x4f().modelViewCoordsMatrixs4x4(0.0f, 0.0f, 0.0f, 45.0f, 45.0f, 0.0f);
		
		/*String.format("%f %f %f %f \n %f %f %f %f \n %f %f %f %f \n %f %f %f %f", defaultMat.getENTRY0_0(), defaultMat.getENTRY0_1(), defaultMat.getENTRY0_2(), defaultMat.getENTRY0_3(),
			defaultMat.getENTRY1_0(), defaultMat.getENTRY1_1(), defaultMat.getENTRY1_2(), defaultMat.getENTRY1_3(),
			defaultMat.getENTRY2_0(), defaultMat.getENTRY2_1(), defaultMat.getENTRY2_2(), defaultMat.getENTRY2_3(),
			defaultMat.getENTRY3_0(), defaultMat.getENTRY3_1(), defaultMat.getENTRY3_2(), defaultMat.getENTRY3_3());*/
		
		//System.out.print(defaultMat.getENTRY0_0()); System.out.print(defaultMat.getENTRY0_1()); System.out.print(defaultMat.getENTRY0_2()); System.out.println(defaultMat.getENTRY0_3());
		//System.out.print(defaultMat.getENTRY1_0()); System.out.print(defaultMat.getENTRY1_1()); System.out.print(defaultMat.getENTRY1_2()); System.out.println(defaultMat.getENTRY1_3());
		//System.out.print(defaultMat.getENTRY2_0()); System.out.print(defaultMat.getENTRY2_1()); System.out.print(defaultMat.getENTRY2_2()); System.out.println(defaultMat.getENTRY2_3());
		//System.out.print(defaultMat.getENTRY3_0()); System.out.print(defaultMat.getENTRY3_1()); System.out.print(defaultMat.getENTRY3_2()); System.out.println(defaultMat.getENTRY3_3());
	}
	
	
	public static hVector3D transformHVector3D(TransformationMatrix4x4f transformationMatrix4x4, hVector3D inputSeedHVector3D) {
		float[] hVector3DAtt = {inputSeedHVector3D.getXCOORD()*transformationMatrix4x4.getENTRY0_0() + inputSeedHVector3D.getYCOORD()*transformationMatrix4x4.getENTRY0_1() + inputSeedHVector3D.getZCOORD()*transformationMatrix4x4.getENTRY0_2() + inputSeedHVector3D.getHWCOORD()*transformationMatrix4x4.getENTRY0_3(),
		inputSeedHVector3D.getXCOORD()*transformationMatrix4x4.getENTRY1_0() + inputSeedHVector3D.getYCOORD()*transformationMatrix4x4.getENTRY1_1() + inputSeedHVector3D.getZCOORD()*transformationMatrix4x4.getENTRY1_2() + inputSeedHVector3D.getHWCOORD()*transformationMatrix4x4.getENTRY1_3(),
		inputSeedHVector3D.getXCOORD()*transformationMatrix4x4.getENTRY2_0() + inputSeedHVector3D.getYCOORD()*transformationMatrix4x4.getENTRY2_1() + inputSeedHVector3D.getZCOORD()*transformationMatrix4x4.getENTRY2_2() + inputSeedHVector3D.getHWCOORD()*transformationMatrix4x4.getENTRY2_3(),
		inputSeedHVector3D.getXCOORD()*transformationMatrix4x4.getENTRY3_0() + inputSeedHVector3D.getYCOORD()*transformationMatrix4x4.getENTRY3_1() + inputSeedHVector3D.getZCOORD()*transformationMatrix4x4.getENTRY3_2() + inputSeedHVector3D.getHWCOORD()*transformationMatrix4x4.getENTRY3_3()};
		return new hVector3D(hVector3DAtt);
	}
	
	public static TransformationMatrix4x4f transposeMatrix4x4(TransformationMatrix4x4f transformationMatrix4x4) {
		float[][] transposeMatrix4DArr = {{transformationMatrix4x4.getENTRY0_0(), transformationMatrix4x4.getENTRY1_0(), transformationMatrix4x4.getENTRY2_0(), transformationMatrix4x4.getENTRY3_0()},
		{transformationMatrix4x4.getENTRY0_1(), transformationMatrix4x4.getENTRY1_1(), transformationMatrix4x4.getENTRY2_1(), transformationMatrix4x4.getENTRY3_1()},
		{transformationMatrix4x4.getENTRY0_2(), transformationMatrix4x4.getENTRY1_2(), transformationMatrix4x4.getENTRY2_2(), transformationMatrix4x4.getENTRY3_2()},
		{transformationMatrix4x4.getENTRY0_3(), transformationMatrix4x4.getENTRY1_3(), transformationMatrix4x4.getENTRY2_3(), transformationMatrix4x4.getENTRY3_3()}};
		return new TransformationMatrix4x4f(transposeMatrix4DArr);
	}//MANIFESTATION OF THE ROW SPACE
	
	
	//Transform orthogonal matrix about camera space via inverse is the adjoint transpose of the transform matrix
	public TransformationMatrix4x4f orthogonalTransformAboutADJOINTCAMERAANGLE() {
		return TransformationMatrix4x4f.transposeMatrix4x4(this);
		//To be overriden only by the subclass translationTransformationMatrix4x4f
		//To be implemented only by the subclasses rotationXTRANSFORMAITONMATRIX4X4, rotationYTRANSFORMAITONMATRIX4X4, rotationZTRANSFORMAITONMATRIX4X4 as extensions
	}
	
	public TransformationMatrix4x4f RotationXHTransform(float angle) {
		/*this.THETAXPITCHCOS = -Math.cos(angle*Math.PI/180);
		this.THETAXPITCHSIN =-Math.sin(angle*Math.PI/180);
		float[][] xPitchHMatrix =-{{},
				{},
				{},
				{}};
		-+super(xPitchHMatrix);*/
		// TODO Auto-generated constructor stub
		//using a look-at matrix for camera transforms is generally compuationally faster!
		return new TransformationMatrix4x4f(new float[][]{{1, 0, 0, 0},
			{0, (float) Math.cos(angle*Math.PI/180), (float) -Math.sin(angle*Math.PI/180), 0},
			{0, (float) Math.sin(angle*Math.PI/180), (float) Math.cos(angle*Math.PI/180), 0},
			{0, 0, 0, 1}});
	}
	
	public static TransformationMatrix4x4f rotXYZHTransformABOUTADJOINTCAMERAANGLEMATRIX(TransformationMatrix4x4f transformationMatrix4x4, TransformationMatrix4x4f inputSeedMatrix4x4) {
		return TransformationMatrix4x4f.transformMatrix4x4(transformationMatrix4x4.orthogonalTransformAboutADJOINTCAMERAANGLE(), inputSeedMatrix4x4                                  );
	}//The transpose of an orthogonal orthonormal rotation transform matrix is its corresponding inverse,
	//so to rotate from the camera space via the inverse transformation, simply transpose the world model space rotation transformation matrix.
	
	public TransformationMatrix4x4f RotationYHTransform(float angle) {
		/*this.PHIYYAWCOS = Math.cos(angle*Math.PI/180);
		this.PHIYYAWSIN = Math.sin(angle*Math.PI/180);
		float[][] yYawHMatrix = {{},
				{},
				{},
				{}};*/
		// TODO Auto-generated constructor stub
		return new TransformationMatrix4x4f(new float[][]{{(float) Math.cos(angle*Math.PI/180), 0, (float) Math.sin(angle*Math.PI/180), 0},
			{0, 1, 0, 0},
			{(float) -Math.sin(angle*Math.PI/180), 0, (float) Math.cos(angle*Math.PI/180), 0},
			{0, 0, 0, 1}});
	}
	
	/*public static TransformationMatrix4x4f rotYHTransformABOUTADJOINTCAMERAANGLEMATRIX(RotationXHTransform transformationMatrix4x4, TransformationMatrix4x4f inputSeedMatrix4x4) {
		return TransformationMatrix4x4f.transformMatrix4x4(transformationMatrix4x4.orthogonalTransformAboutADJOINTCAMERAANGLE(), inputSeedMatrix4x4                                  );
	}*/
	
	public TransformationMatrix4x4f RotationZHTransform(float angle) {
		/*this.PSIZROLLCOS = Math.cos(angle*Math.PI/180);
		this.PSIZROLLSIN = Math.sin(angle*Math.PI/180);
		float[][] zRollHMatrix = {{},
				{},
				{},
				{}};*/
		return new TransformationMatrix4x4f(new float[][]{{(float) Math.cos(angle*Math.PI/180), (float) -Math.sin(angle*Math.PI/180), 0, 0},
			{(float) Math.sin(angle*Math.PI/180), (float) Math.cos(angle*Math.PI/180), 0, 0},
			{0, 0, 1, 0},
			{0, 0, 0, 1}});
		// TODO Auto-generated constructor stub
	}
	
	/*public static TransformationMatrix4x4f rotZHTransformABOUTADJOINTCAMERAANGLEMATRIX(RotationXHTransform transformationMatrix4x4, TransformationMatrix4x4f inputSeedMatrix4x4) {
		return TransformationMatrix4x4f.transformMatrix4x4(transformationMatrix4x4.orthogonalTransformAboutADJOINTCAMERAANGLE(), inputSeedMatrix4x4                                  );
	}*/
	
	public TransformationMatrix4x4f rotateToWorldViewCoords(float THETAXPITCH, float PHIYYAW, float PSIZROLL) {
		return rotXYZHTransformABOUTADJOINTCAMERAANGLEMATRIX(RotationZHTransform(THETAXPITCH), rotXYZHTransformABOUTADJOINTCAMERAANGLEMATRIX(RotationYHTransform(PHIYYAW), rotXYZHTransformABOUTADJOINTCAMERAANGLEMATRIX(RotationXHTransform(PSIZROLL), this)));
	}
	
	public TransformationMatrix4x4f rotateModelViewCoords(float THETAXPITCH, float PHIYYAW, float PSIZROLL) {
		return this.rotateToWorldViewCoords(-PSIZROLL, -PHIYYAW, -THETAXPITCH);
	}
	
	public TransformationMatrix4x4f transformMatrix4x4(TransformationMatrix4x4f transformationMatrix4x4) {
		return transformMatrix4x4(this, transformationMatrix4x4);
	}
	
	public TransformationMatrix4x4f translateCoords(float X, float Y, float Z) {
		TransformationMatrix4x4f translationXYZ = new TransformationMatrix4x4f(new float[][]{{1, 0, 0, X},
			{0, 1, 0, Y},
			{0, 0, 1, Z},
			{0, 0, 0, 1}});
		 return translationXYZ.transformMatrix4x4(this);
	}
	
	public TransformationMatrix4x4f translateToWorldViewCoords(float X, float Y, float Z) {
		return this.translateCoords(-X, -Y, -Z);
	}
	
	public TransformationMatrix4x4f scaleCoords(float X, float Y, float Z) {
		TransformationMatrix4x4f scaleXYZ = new TransformationMatrix4x4f(new float[][]{{X, 0, 0, 0},
			{0, Y, 0, 0},
			{0, 0, Z, 0},
			{0, 0, 0, 1}});
		 return scaleXYZ.transformMatrix4x4(this);
	}
	
	public TransformationMatrix4x4f modelViewCoordsMatrixs4x4(float X, float Y, float Z, float THETAXPITCH, float PHIYYAW, float PSIZROLL) {
		return this.translateToWorldViewCoords(X, Y, Z).rotateToWorldViewCoords(THETAXPITCH, PHIYYAW, PSIZROLL);
	}
	

	public static TransformationMatrix4x4f projectionMatrix4x4(float topToBottomFOV, float aspectRatio, float ZNEAR, float ZFAR, int sCRNWidth, int sCRNHeight) {
		float invFrustum = (float) (1/(Math.tan(topToBottomFOV*0.5*Math.PI/180)));
		float depthCoefficient = 1/(ZNEAR-ZFAR);
		return new TransformationMatrix4x4f(new float[][]{{0.5f*sCRNWidth*invFrustum/aspectRatio, 0, 0, 0},
			{0, 0.5f*sCRNHeight*invFrustum, 0, 0},
			{0, 0, (ZNEAR+ZFAR)*depthCoefficient, 2*ZNEAR*ZFAR*depthCoefficient},
			{0, 0, -1, 0}});
	}
	
	public static float[] mat4GLSL(TransformationMatrix4x4f transformationMatrix4x4) {
		return new float[] {(float) transformationMatrix4x4.getENTRY0_0(), (float) transformationMatrix4x4.getENTRY1_0(), (float) transformationMatrix4x4.getENTRY2_0(), (float) transformationMatrix4x4.getENTRY3_0(),
				(float) transformationMatrix4x4.getENTRY0_1(), (float) transformationMatrix4x4.getENTRY1_1(), (float) transformationMatrix4x4.getENTRY2_1(), (float) transformationMatrix4x4.getENTRY3_1(),
				(float) transformationMatrix4x4.getENTRY0_2(), (float) transformationMatrix4x4.getENTRY1_2(), (float) transformationMatrix4x4.getENTRY2_2(), (float) transformationMatrix4x4.getENTRY3_2(),
				(float) transformationMatrix4x4.getENTRY0_3(), (float) transformationMatrix4x4.getENTRY1_3(), (float) transformationMatrix4x4.getENTRY2_3(), (float) transformationMatrix4x4.getENTRY3_3()};
	}
	
	public static float[][] mat4GLSLf(TransformationMatrix4x4f transformationMatrix4x4) {
		return new float[][] {{(float) transformationMatrix4x4.getENTRY0_0(), (float) transformationMatrix4x4.getENTRY1_0(), (float) transformationMatrix4x4.getENTRY2_0(), (float) transformationMatrix4x4.getENTRY3_0()},
				{(float) transformationMatrix4x4.getENTRY0_1(), (float) transformationMatrix4x4.getENTRY1_1(), (float) transformationMatrix4x4.getENTRY2_1(), (float) transformationMatrix4x4.getENTRY3_1()},
				{(float) transformationMatrix4x4.getENTRY0_2(), (float) transformationMatrix4x4.getENTRY1_2(), (float) transformationMatrix4x4.getENTRY2_2(), (float) transformationMatrix4x4.getENTRY3_2()},
				{(float) transformationMatrix4x4.getENTRY0_3(), (float) transformationMatrix4x4.getENTRY1_3(), (float) transformationMatrix4x4.getENTRY2_3(), (float) transformationMatrix4x4.getENTRY3_3()}};
	}
	
	public TransformationMatrix4x4f() { //NULL constructor
		this.ENTRY0_0 = 1.0f;
		this.ENTRY0_1 = 0.0f;
		this.ENTRY0_2 = 0.0f;
		this.ENTRY0_3 = 0.0f;
		this.ENTRY1_0 = 0.0f;
		this.ENTRY1_1 = 1.0f;
		this.ENTRY1_2 = 0.0f;
		this.ENTRY1_3 = 0.0f;
		this.ENTRY2_0 = 0.0f;
		this.ENTRY2_1 = 0.0f;
		this.ENTRY2_2 = 1.0f;
		this.ENTRY2_3 = 0.0f;
		this.ENTRY3_0 = 0.0f;
		this.ENTRY3_1 = 0.0f;
		this.ENTRY3_2 = 0.0f;
		this.ENTRY3_3 = 1.0f;
	}
	
	//TRANSPOSED INVERSE/ INVERTED TRANSPOSE

	public float getENTRY0_0() {
		return ENTRY0_0;
	}

	public float getENTRY0_1() {
		return ENTRY0_1;
	}

	public float getENTRY0_2() {
		return ENTRY0_2;
	}

	public float getENTRY0_3() {
		return ENTRY0_3;
	}

	public float getENTRY1_0() {
		return ENTRY1_0;
	}

	public float getENTRY1_1() {
		return ENTRY1_1;
	}

	public float getENTRY1_2() {
		return ENTRY1_2;
	}

	public float getENTRY1_3() {
		return ENTRY1_3;
	}

	public float getENTRY2_0() {
		return ENTRY2_0;
	}

	public float getENTRY2_1() {
		return ENTRY2_1;
	}

	public float getENTRY2_2() {
		return ENTRY2_2;
	}

	public float getENTRY2_3() {
		return ENTRY2_3;
	}

	public float getENTRY3_0() {
		return ENTRY3_0;
	}

	public float getENTRY3_1() {
		return ENTRY3_1;
	}

	public float getENTRY3_2() {
		return ENTRY3_2;
	}

	public float getENTRY3_3() {
		return ENTRY3_3;
	}

	
}

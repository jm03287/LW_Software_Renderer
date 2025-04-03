import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphicsEngine extends JPanel{

	private float cameraX, cameraY, cameraZ;
	private float cubeLocX, cubeLocY, cubeLocZ;
	private int cubeSize;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		Dimension size = getSize();
		Insets insets = getInsets();
		int width = size.width - insets.right - insets.left;
		int height = size.height - insets.bottom - insets.top;
		cameraX = 0f; cameraY = 3f; cameraZ = 5f;
		cubeLocX = 0.0f; cubeLocY = 0.0f; cubeLocZ = 0.0f;
		float aspect = width / height;
		int cubeSize = 1;
		
		TransformationMatrix4x4f mMat = new TransformationMatrix4x4f();
		mMat = mMat.scaleCoords(cubeSize, cubeSize, cubeSize).rotateModelViewCoords(0f, 135f, 15f).translateCoords(cubeLocX, cubeLocY, cubeLocZ);
		
		TransformationMatrix4x4f pMat = TransformationMatrix4x4f.projectionMatrix4x4(75.0f, aspect, 0.1f, 100f, width, height);

		TransformationMatrix4x4f mvMat = mMat.modelViewCoordsMatrixs4x4(cameraX, cameraY, cameraZ, 0f, 0f, -40f);
		TransformationMatrix4x4f mvpMat = pMat.transformMatrix4x4(mvMat);
		
		ArrayList<Triangle> cube= new ArrayList<Triangle>();
		cube.add(new Triangle(new float[]{-1f, -1f, -1f},new float[]{-1f, 1f, 1f},new float[]{-1f, 1f, -1f}));
		cube.add(new Triangle(new float[]{-1f, -1f, -1f},new float[]{-1f, 1f, 1f},new float[]{-1f, -1f, 1f}));
		cube.add(new Triangle(new float[]{-1f, -1f, 1f},new float[]{1f, 1f, 1f},new float[]{1f, -1f, 1f}));
		cube.add(new Triangle(new float[]{-1f, -1f, 1f},new float[]{1f, 1f, 1f},new float[]{-1f, 1f, 1f}));
		cube.add(new Triangle(new float[]{1f, -1f, 1f},new float[]{1f, 1f, -1f},new float[]{1f, 1f, 1f}));
		cube.add(new Triangle(new float[]{1f, -1f, 1f},new float[]{1f, 1f, -1f},new float[]{1f, -1f, -1f}));
		cube.add(new Triangle(new float[]{1f, -1f, -1f},new float[]{-1f, 1f, -1f},new float[]{1f, 1f, -1f}));
		cube.add(new Triangle(new float[]{1f, -1f, -1f},new float[]{-1f, 1f, -1f},new float[]{-1f, -1f, -1f}));
		cube.add(new Triangle(new float[]{-1f, -1f, -1f},new float[]{1f, -1f, 1f},new float[]{-1f, -1f, 1f}));
		cube.add(new Triangle(new float[]{-1f, -1f, -1f},new float[]{1f, -1f, 1f},new float[]{1f, -1f, -1f}));
		cube.add(new Triangle(new float[]{-1f, 1f, 1f},new float[]{1f, 1f, -1f},new float[]{-1f, 1f, -1f}));
		cube.add(new Triangle(new float[]{-1f, 1f, 1f},new float[]{1f, 1f, -1f},new float[]{1f, 1f, 1f}));
		
		ArrayList<ArrayList<hVector3D>> cubeData = initModel(cube);
		cubeData = transformModel(cubeData, mvMat);
		cubeData = depthTransfer(cubeData);
		cubeData = transformModel(cubeData, pMat);
		
		for(int i = 0; i < cubeData.size(); i++) {
			int XCoord1 = (int)((cubeData.get(i).get(0).getXCOORD()/cubeData.get(i).get(0).getHWCOORD())+(width*0.5f));
			int YCoord1 = (int)(-1*(cubeData.get(i).get(0).getYCOORD()/cubeData.get(i).get(0).getHWCOORD())+(width*0.5f));
			int XCoord2 = (int)((cubeData.get(i).get(1).getXCOORD()/cubeData.get(i).get(1).getHWCOORD())+(width*0.5f));
			int YCoord2 = (int)(-1*(cubeData.get(i).get(1).getYCOORD()/cubeData.get(i).get(1).getHWCOORD())+(width*0.5f));
			int XCoord3 = (int)((cubeData.get(i).get(2).getXCOORD()/cubeData.get(i).get(2).getHWCOORD())+(width*0.5f));
			int YCoord3 = (int)(-1*(cubeData.get(i).get(2).getYCOORD()/cubeData.get(i).get(2).getHWCOORD())+(width*0.5f));
			
			g2d.setColor(Color.red);
			
			ArrayList<ArrayList<hVector3D>> rasterA = fillTriangle(XCoord1, YCoord1, XCoord2, YCoord2, XCoord3, YCoord3);
			for(int j = 0; j < rasterA.size(); j++) {
				g2d.drawLine((int) rasterA.get(j).get(0).getXCOORD(), (int) rasterA.get(j).get(0).getYCOORD(), (int) rasterA.get(j).get(1).getXCOORD(), (int) rasterA.get(j).get(1).getYCOORD());
			}
			
			ArrayList<ArrayList<hVector3D>> rasterB = fillTriangle(XCoord2, YCoord2, XCoord3, YCoord3, XCoord1, YCoord1);
			for(int j = 0; j < rasterB.size(); j++) {
				g2d.drawLine((int) rasterB.get(j).get(0).getXCOORD(), (int) rasterB.get(j).get(0).getYCOORD(), (int) rasterB.get(j).get(1).getXCOORD(), (int) rasterB.get(j).get(1).getYCOORD());
			}
			
			ArrayList<ArrayList<hVector3D>> rasterC = fillTriangle(XCoord3, YCoord3, XCoord1, YCoord1, XCoord2, YCoord2);
			for(int j = 0; j < rasterC.size(); j++) {
				g2d.drawLine((int) rasterC.get(j).get(0).getXCOORD(), (int) rasterC.get(j).get(0).getYCOORD(), (int) rasterC.get(j).get(1).getXCOORD(), (int) rasterC.get(j).get(1).getYCOORD());
			}
			
			g2d.setColor(Color.black);
			g2d.drawLine(XCoord1, YCoord1, XCoord2, YCoord2);
			g2d.drawLine(XCoord2, YCoord2, XCoord3, YCoord3);
			g2d.drawLine(XCoord3, YCoord3, XCoord1, YCoord1);
		}
		
	}
	
	
	
	public ArrayList<ArrayList<hVector3D>> initModel(ArrayList<Triangle> triangles) {
		ArrayList<ArrayList<hVector3D>> vecArr = new ArrayList<ArrayList<hVector3D>>();
		for(int i = 0; i < triangles.size(); i++) {
				vecArr.add(new ArrayList<hVector3D>(Arrays.asList(triangles.get(i).getVertex1(),triangles.get(i).getVertex2(),triangles.get(i).getVertex3())));
		}
		return vecArr;
	}
	
	public ArrayList<ArrayList<hVector3D>> transformModel(ArrayList<ArrayList<hVector3D>> modelData, TransformationMatrix4x4f tMat) {
		ArrayList<ArrayList<hVector3D>> vecArr = new ArrayList<ArrayList<hVector3D>>();
		for(int i = 0; i < modelData.size(); i++) {
			vecArr.add(new ArrayList<hVector3D>(Arrays.asList(TransformationMatrix4x4f.transformHVector3D(tMat, modelData.get(i).get(0)),TransformationMatrix4x4f.transformHVector3D(tMat, modelData.get(i).get(1)),TransformationMatrix4x4f.transformHVector3D(tMat, modelData.get(i).get(2)))));
		}
		return vecArr;
	}
	
	public ArrayList<ArrayList<hVector3D>> fillTriangle(int XCoord1, int YCoord1, int XCoord2, int YCoord2, int XCoord3, int YCoord3){
		hVector3D sideA = new hVector3D(new float[] {(float) XCoord2-XCoord1, (float) YCoord2-YCoord1, 0f, 0f});
		hVector3D sideB = new hVector3D(new float[] {(float) XCoord3-XCoord1, (float) YCoord3-YCoord1, 0f, 0f});
		ArrayList<ArrayList<hVector3D>> cCoords = new ArrayList<ArrayList<hVector3D>>();
		for(int pixel = 1; pixel < sideA.getMagnitude(); pixel++) {
			cCoords.add(new ArrayList<hVector3D>(Arrays.asList(new hVector3D(new float[] {sideA.getXCOORD()*pixel/sideA.getMagnitude() + XCoord1, sideA.getYCOORD()*pixel/sideA.getMagnitude() + YCoord1, 0f, 0f}),new hVector3D(new float[] {sideB.getXCOORD()*pixel/sideA.getMagnitude() + XCoord1, sideB.getYCOORD()*pixel/sideA.getMagnitude() + YCoord1, 0f, 0f}))));
		}
		return cCoords;
	}
	
	public hVector3D getTriangleDepth(ArrayList<hVector3D> triCoords) {
		TransformationMatrix4x4f characteristicMat = new TransformationMatrix4x4f(new float[][]{{triCoords.get(0).getXCOORD(),triCoords.get(1).getXCOORD(),triCoords.get(2).getXCOORD(),0f},
				{triCoords.get(0).getYCOORD(),triCoords.get(1).getYCOORD(),triCoords.get(2).getYCOORD(),0f},
				{triCoords.get(0).getZCOORD(),triCoords.get(1).getZCOORD(),triCoords.get(2).getZCOORD(),0f},
				{0f, 0f, 0f, 1f}});
		hVector3D focalZ = null; 
		float furthestVert = Math.min(triCoords.get(0).getZCOORD(), Math.min(triCoords.get(1).getZCOORD(), triCoords.get(2).getZCOORD()));
		if(!(furthestVert == characteristicMat.getENTRY2_0() && furthestVert == characteristicMat.getENTRY2_1() && furthestVert == characteristicMat.getENTRY2_2())) {
			if(furthestVert == characteristicMat.getENTRY2_0()) {
				focalZ = new hVector3D(new float[] {0.5f, 0.25f, 0.25f, 0f});
			}
			else if(furthestVert == characteristicMat.getENTRY2_1()) {
				focalZ = new hVector3D(new float[] {0.25f, 0.5f, 0.25f, 0f});
			}
			else if(furthestVert == characteristicMat.getENTRY2_2()) {
				focalZ = new hVector3D(new float[] {0.25f, 0.25f, 0.5f, 0f});
			}
		}
		else {
			focalZ = new hVector3D(new float[] {0.33f, 0.33f, 0.33f, 0f});
		}
		return TransformationMatrix4x4f.transformHVector3D(characteristicMat, focalZ);
	}
	
	public ArrayList<ArrayList<hVector3D>> depthTransfer(ArrayList<ArrayList<hVector3D>> modelData){
		for(int i = 0; i < modelData.size(); i++) {
			ArrayList<hVector3D> zBuffer = modelData.get(i);
			for(int j = i + 1; j < modelData.size(); j++) {
				if(getTriangleDepth(zBuffer).getMagnitude() < getTriangleDepth(modelData.get(j)).getMagnitude()) {
					zBuffer = modelData.get(j);
					modelData.set(j, modelData.get(i));
					modelData.set(i, zBuffer);
				}
			}
		}
		return modelData;
	}
	
	
	
	public GraphicsEngine() {
		// TODO Auto-generated constructor stub
	}
	
	public static void debugLib() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		debugLib();
		GraphicsEngine graphicsEngine = new GraphicsEngine();
		JFrame frame = new JFrame("Sample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(graphicsEngine);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

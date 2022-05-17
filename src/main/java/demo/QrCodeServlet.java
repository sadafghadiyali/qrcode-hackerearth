package demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * Servlet implementation class QrCodeServlet
 */
@WebServlet("/qrcode")
public class QrCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("url");
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		byte[] qrBytes = getQRCodeImage(url,400,400);
		outputStream.write(qrBytes);
		outputStream.flush();
		outputStream.close();
		
	}

	private byte[] getQRCodeImage(String path, int widht, int height) {
		try {
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix bitMatrix = qrCodeWriter.encode(path, BarcodeFormat.QR_CODE, widht, height);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "png",byteArrayOutputStream);
			return byteArrayOutputStream.toByteArray();
		}catch(Exception e 	) {
			return null;
		}
	}
	

}

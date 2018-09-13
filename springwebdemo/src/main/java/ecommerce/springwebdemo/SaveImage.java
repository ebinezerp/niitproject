package ecommerce.springwebdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import ecommerce.database.model.Product;
import ecommerce.database.model.products.Laptop;

@Service
public class SaveImage {

	public void saveImage(Product product, HttpServletRequest request) {
		File file = new File(request.getRealPath("/") + "/resources/images/products/");

		System.out.println(file.getPath());
		if (!file.exists()) {
			file.mkdir();
		}

		FileOutputStream fileOutputStream=null;
		 
		try {
			
			fileOutputStream=new FileOutputStream(file.getPath()+"/"+product.getProductId()+".jpg");
			 InputStream inputStream=product.getImage().getInputStream();
			 
			 byte[] imageBytes=new byte[inputStream.available()];
			 
			 inputStream.read(imageBytes);
			 
			 fileOutputStream.write(imageBytes);
			 fileOutputStream.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

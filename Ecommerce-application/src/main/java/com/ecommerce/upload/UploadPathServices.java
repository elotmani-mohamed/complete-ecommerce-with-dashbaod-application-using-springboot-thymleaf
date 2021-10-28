package com.ecommerce.upload;

import java.io.File;

public interface UploadPathServices {

	File getFilePath(String modifiedFileName, String path);

}

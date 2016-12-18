package main.java.portfolio.services;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.*;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.File;

public class S3CloudStorage implements CloudStorage {
	private AmazonS3Client s3;
	private Region region;
	private String bucketName;

	public S3CloudStorage() {
		s3 = new AmazonS3Client();
		region = Region.getRegion(Regions.US_WEST_2);
		s3.setRegion(region);
		bucketName = System.getenv("PORTFOLIO_S3_BUCKET");
	}

	public String put(String key, File file) throws Exception {
		s3.putObject(new PutObjectRequest(bucketName, key, file).withCannedAcl(CannedAccessControlList.PublicRead));
		return s3.getResourceUrl(bucketName, key);
	}
}
public static void saveImage(String imageUITP_Week12_DSAI03ITP_Week12_DSAI03rl) {
URL url = new URL(imageUrl);
String fileName = url.getFile();
String destName = "./figures" + fileName.substring(fileName.lastIndexOf("/"));
System.out.println(destName);
InputStream is = url.openStream();
OutputStream os = new FileOutputStream(destName);
byte[] b = new byte[2048];
int length;
while ((length = is.read(b)) != -1) {
os.write(b, 0, length);
}
is.close();
os.close();
} 16

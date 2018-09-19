package lsb;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * LSB图片信息隐藏实现
 */

public class ImgHider {

    //隐藏信息，参数为所要隐藏信息的图片完整路径（包括文件名）
    public void hideInfor(String infoPath) {
        try {
            //获得加密信息图片和载体图片的像素rgb值二进制数组
            BufferedImage infoImg = ImageIO.read(new File(infoPath));
            BufferedImage carrierImg = ImageIO.read(new File("d://lena.bmp"));

            //验证所加密图片尺寸是否不大于载体尺寸
            if(infoImg.getWidth()<=carrierImg.getWidth() && infoImg.getHeight()<carrierImg.getHeight()) {

                //将载体图片二进制码的RGB值中的G位(Green)全部设为偶数
                for(int i = 0; i<carrierImg.getWidth(); i++) {
                    for (int j = 0; j<carrierImg.getHeight(); j++) {
                        //获得该像素位的RGB值
                        Color color = new Color(carrierImg.getRGB(i,j));
                        //得到Green位数值
                        int g = color.getGreen();
                        if(g % 2 != 0) {
                            Color newColor;
                            //更新RGB值，将G位变为偶数
                            if (g > 2) {
                                newColor = new Color(color.getRed(),color.getGreen()-1,color.getBlue());
                            } else {
                                newColor = new Color(color.getRed(),color.getGreen()+1,color.getBlue());
                            }
                            carrierImg.setRGB(i,j,newColor.getRGB());
                        }
                    }
                }

                //隐藏信息，嵌入文字信息至载体图中
                //当密码图片中遍历到有文字信息的像素点之后，将载体中的同坐标像素点的G位变为奇数（+1）
                int r,g,b;
                for(int i = 0; i<infoImg.getWidth(); i++) {
                    for(int j = 0; j<infoImg.getHeight(); j++) {
                        Color color = new Color(infoImg.getRGB(i,j));
                        //得到 R G B 三位数字的值
                        r = color.getRed();
                        g = color.getGreen();
                        b = color.getBlue();
                        if(r<200 && g<200 && b<200) {
                            Color nowColor = new Color(carrierImg.getRGB(i,j));
                            Color newColor = new Color(nowColor.getRed(),nowColor.getGreen()+1,nowColor.getBlue());
                            carrierImg.setRGB(i,j,newColor.getRGB());
                        }
                    }
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日-HH时mm分ss秒");
                String fname = "d://secret_"+sdf.format(new Date())+".bmp";
                ImageIO.write(carrierImg,"bmp",new File(fname));
                System.out.println("已成功隐藏信息！图片路径为： "+fname);

            } else {
                System.err.println("请选择尺寸不大于512x512的图片！！");
                return;
            }
        } catch (IIOException e) {
            System.err.println("请输入正确的文件路径！");
            return;
        } catch (Exception e) {
            System.err.println("出现异常！请重试！！");
            return;
        }
    }

    //找出信息，参数为隐藏信息的图片的完整路径（包括文件名）
    //对隐藏信息的图片的像素位进行遍历，若其G位为奇数，将该像素为设为黑色，否则设为白色
    public void findInfor(String hidePath) {
        int rgb,g;
        try {
            BufferedImage secretImg = ImageIO.read(new File(hidePath));
            Color black = new Color(1);
            Color white = new Color(-1);
            for (int i = 0; i<secretImg.getWidth(); i++) {
                for (int j = 0; j<secretImg.getHeight(); j++) {
                    g = new Color(secretImg.getRGB(i,j)).getGreen();
                    if(g % 2 != 0) {
                        //文字部分
                        secretImg.setRGB(i,j,black.getRGB());
                    } else {
                        //空白部分
                        secretImg.setRGB(i,j,white.getRGB());
                    }
                }
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日-HH时mm分ss秒");
            String fname = "d://info_"+sdf.format(new Date())+".bmp";
            ImageIO.write(secretImg,"bmp",new File(fname));
            System.out.println("已成功提取隐藏信息！图片路径为： "+fname);
        } catch (IIOException e) {
            System.err.println("请输入正确的文件路径！");
        } catch (Exception e) {
            System.err.println("出现异常！请重试！！");
        }
    }
}

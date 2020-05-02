import com.alibaba.fastjson.JSONPath;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;

public class MainClass {




    public static void main(String[] args) throws Exception {

        String token = "default";
        String appkey = "default";
        String url = "111";
        String request = "222";
        String format = "pcm";
        int sampleRate = 16000;
        boolean enablePunctuationPrediction = true;
        boolean enableInverseTextNormalization = true;
        boolean enableVoiceDetection = true;

        request = request + "?appkey=" + appkey;
        request = request + "&format=" + format;
        request = request + "&sample_rate=" + sampleRate;
        if (enablePunctuationPrediction) {
            request = request + "&enable_punctuation_prediction=" + true;
        }
        if (enableInverseTextNormalization) {
            request = request + "&enable_inverse_text_normalization=" + true;
        }
        if (enableVoiceDetection) {
            request = request + "&enable_voice_detection=" + true;
        }


        System.out.println("Request: " + request);
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("X-NLS-Token", token);
        headers.put("Content-Type", "application/octet-stream");
//        headers.put("Content-Length", String.valueOf(getVoiceData().length));
        headers.put("Host", url);



        String response = HttpUtil.sendPostData(request, headers, getVoiceData());
        if (response != null) {
            System.out.println("Response: " + response);
            String result = JSONPath.read(response, "result").toString();
            System.out.println("识别结果：" + result);
        } else {
            System.err.println("识别失败!");
        }
    }




    public static byte[] getVoiceData() throws IOException {
        String voice64 = new String(Base64.getEncoder().encode(Base64Covert.file2Byte()));
        byte[] voiceBytes = Base64.getDecoder().decode(voice64);

        String voice64FromApp = "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";
        String voice64FromApp2 = voice64FromApp.replace("\\r\\n", "");
        System.out.println(voice64FromApp2);
//        byte[] voiceBytes = Base64.getDecoder()
        return voiceBytes;
    }



}




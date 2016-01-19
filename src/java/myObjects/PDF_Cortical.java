/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myObjects;

import io.cortical.rest.model.Fingerprint;
import io.cortical.services.RetinaApis;
import io.cortical.services.Texts;
import io.cortical.services.api.client.ApiException;
import java.util.List;

/**
 *
 * @author Roman Toda <roman.toda@gmail.com>
 */
public class PDF_Cortical {
    private final RetinaApis retinaApisInstance;
    
    public PDF_Cortical() {
        retinaApisInstance = new RetinaApis("en_associative", "api.cortical.io", myObjects.Settings.CORTICAL_API_KEY );
    }

    
    public Fingerprint getStringFingerPrint(String text) throws ApiException {
        Texts api = retinaApisInstance.textApi();            
        List<Fingerprint> fingerprints = api.getFingerprints(text);
        return fingerprints.get(0);
    }
    
//    public Fingerprint getFileFingerPrint(InputStream pdfStream) throws ApiException {
//        String text2 =
//                "Shellshock can serve as a highway for worms and malware to hit your Unix, Linux, and Mac servers, but you can defend against it.";        
//        return getStringFingerPrint(text2);
//    }   
}




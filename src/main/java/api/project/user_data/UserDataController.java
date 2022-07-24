package api.project.user_data;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequiredArgsConstructor
@Component
public class UserDataController {

    private final UserDataRepository userDataRepository;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadFile2(
            @RequestParam(name = "file") MultipartFile file
    ) {

        var dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
            br.readLine();
            String line;

            log.info("Starting to read uploaded file");

            while ((line = br.readLine()) != null) {

                String[] data = line.split(";");
                UserData userData = new UserData();

                userData.setCode(data[0]);
                userData.setDep(data[1]);
                userData.setVisitTime(LocalDateTime.parse(data[2], dateTimeFormatter));
                userData.setFirstName(data[3]);
                userData.setLastName(data[4]);
                userData.setEmail(data[5]);
                userData.setIdCode(Long.valueOf(data[6]));

                userDataRepository.save(userData);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            log.info("Data saved to database");
        }
    }
}

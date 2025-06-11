package me.fit;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import me.fit.model.Polaznik;
import me.fit.repository.PolaznikRepository;
import java.nio.file.Files;
import java.nio.file.Paths; // Koristim Paths za stvaranje putanje
import java.nio.file.StandardCopyOption;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Path("/multipart") // Ovo je jakarta.ws.rs.Path
public class MultipartResource {

    @Inject
    private PolaznikRepository polaznikRepository;

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    public Response uploadFile(
            @QueryParam("id") Long id,
            MultipartRequest request) {
        if (id == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("ID je obavezan parametar")
                    .build();
        }

        // Provjera tipova fajlova
        String fileName = request.getFile().fileName();
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        if (!fileExtension.matches("pdf|jpg|png")) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Dozvoljeni tipovi fajlova su PDF, JPG ili PNG")
                    .build();
        }

        // Učitavanje entiteta
        Polaznik polaznik = polaznikRepository.findById(id);
        if (polaznik == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Polaznik s ID-om " + id + " nije pronađen")
                    .build();
        }

        // Spremanje fajla
        String uploadDir = "uploads";
        java.nio.file.Path uploadPath = Paths.get(uploadDir, fileName); // Eksplicitno specificiran tip
        try {
            Files.createDirectories(uploadPath.getParent());
            java.nio.file.Path tempFile = request.getFile().uploadedFile();
            Files.copy(tempFile, uploadPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Greška pri spremanju fajla: " + e.getMessage())
                    .build();
        }

        // Postavljanje putanje u entitet
        String filePath = uploadPath.toString();
        polaznik.setFilePath(filePath);
        polaznikRepository.savePolaznik(polaznik);

        return Response.ok("Fajl spremljen: " + fileName + ", Putanja: " + filePath).build();
    }

    @Schema(type = SchemaType.STRING, format = "binary")
    public static class UploadSchema {};
}
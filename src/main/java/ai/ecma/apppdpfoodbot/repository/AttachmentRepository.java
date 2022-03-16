package ai.ecma.apppdpfoodbot.repository;

import ai.ecma.apppdpfoodbot.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}

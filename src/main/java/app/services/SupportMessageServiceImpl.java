package app.services;

import app.models.SupportMessage;
import app.repositories.SupportMessageRepository;

public class SupportMessageServiceImpl implements SupportMessageService {
    SupportMessageRepository supportMessageRepository;

    public SupportMessageServiceImpl(SupportMessageRepository supportMessageRepository) {
        this.supportMessageRepository = supportMessageRepository;
    }

    @Override
    public void addSupportMessage(SupportMessage supportMessage) {
        supportMessageRepository.save(supportMessage);
    }
}

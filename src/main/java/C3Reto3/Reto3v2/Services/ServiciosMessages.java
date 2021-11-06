
package C3Reto3.Reto3v2.Services;

import C3Reto3.Reto3v2.Models.Message;
import C3Reto3.Reto3v2.Repositories.RepositorioMessages;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosMessages {
    @Autowired
    private RepositorioMessages metodosCrud;

    public List<Message> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Message> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }

    public Message save(Message message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<Message> e= metodosCrud.getMessage(message.getIdMessage());
            if(e.isEmpty()){
                return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }

    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> e= metodosCrud.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

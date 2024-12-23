package fr.isen.ticketApp.interfaces.services;

import java.util.List;
import fr.isen.ticketApp.interfaces.models.UserModel;

//begin of modifiable zone(Javadoc).......C/660a7900-4aa5-4e78-82a5-9c08e61ff602

//end of modifiable zone(Javadoc).........E/660a7900-4aa5-4e78-82a5-9c08e61ff602
public interface UsersService {
//begin of modifiable zone(Javadoc).......C/11b52dac-a8f4-4e8e-8685-04a0b56f940e

//end of modifiable zone(Javadoc).........E/11b52dac-a8f4-4e8e-8685-04a0b56f940e
    UserModel connexionUsers(final boolean statut);

//begin of modifiable zone(Javadoc).......C/a84b1b3a-8693-4000-b371-484ab120dc5f

//end of modifiable zone(Javadoc).........E/a84b1b3a-8693-4000-b371-484ab120dc5f
    int addUser(final UserModel User);

//begin of modifiable zone(Javadoc).......C/20fdaa4d-5889-4c55-81d2-15122cf47ca4

//end of modifiable zone(Javadoc).........E/20fdaa4d-5889-4c55-81d2-15122cf47ca4
    int removeUser(final int Id);

//begin of modifiable zone(Javadoc).......C/4fbedf17-cee4-4d82-8473-c55b49080d48

//end of modifiable zone(Javadoc).........E/4fbedf17-cee4-4d82-8473-c55b49080d48
    int updateUser(final int Id, final UserModel User);

//begin of modifiable zone(Javadoc).......C/ac91286a-0978-45e2-b6b3-c80cccd0d7d4

//end of modifiable zone(Javadoc).........E/ac91286a-0978-45e2-b6b3-c80cccd0d7d4
    UserModel getUserById(final int Id);

//begin of modifiable zone(Javadoc).......C/f062d960-e2be-42d8-b55a-d83944c3ac61

//end of modifiable zone(Javadoc).........E/f062d960-e2be-42d8-b55a-d83944c3ac61
    List<UserModel> getAllUsers();

}

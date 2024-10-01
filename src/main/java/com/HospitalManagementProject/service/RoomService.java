package com.HospitalManagementProject.service;


import com.HospitalManagementProject.entity.Room;
import com.HospitalManagementProject.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public List<Room> getAvailableRooms() {
        return roomRepository.findByIsOccupied(false);
    }

    public void updateRoomOccupancy(Long id, Boolean isOccupied) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isPresent()) {
            Room room = roomOptional.get();
            room.setIsOccupied(isOccupied);
            roomRepository.save(room);
        }
    }
}

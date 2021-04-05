package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ChatBox;

public interface ChatBoxRepository extends JpaRepository<ChatBox,Integer>{

}

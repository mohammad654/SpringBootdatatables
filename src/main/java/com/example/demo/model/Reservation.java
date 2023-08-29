package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation{

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	// private Customer customer;
	private LocalDateTime date;
	private int tableId;
	private int roomId;
	private boolean seaView;

	public long getId(){ 
		return id;
	}
	public void setId( long id){
		this.id = id;
	}
	public LocalDateTime getDate(){
		return date;
	}
	public void setDate( LocalDateTime date){
		this.date = date;
	}
	public int getTableId(){ 
		return tableId;
	}
	public void setTableId( int tableId){
		this.tableId = tableId;
	}
	public int getRoomId(){ 
		return roomId;
	}
	public void setRoomId( int roomId){
		this.roomId = roomId;
	}
	public boolean getSeaView(){ 
		return seaView;
	}
	public void setSeaView( boolean seaView){
		this.seaView = seaView;
	}

}

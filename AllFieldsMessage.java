package se.acreo.unify.controller.fns.model;

/*
 * Copyright (C) 2015 Acreo Swedish ICT AB.
 *
 * Licensed Information 
 * URL 
 * Description about licence 
 */

//import edu.wisc.cs.wisdom.sdmbn.PerflowKey;

public class AllFieldsMessage extends Message {
	public int count;
	public PerflowKey key;
	public int deltype;
	public String host;
	public int pid;
	public String action;
	public int hashkey;
	public String cause;
	public int raiseEvents;
	public String state;
	public int seq;
	public String header;
	public String packet;
	public String dst;
	public int totalUsers;
	public int totalstates;
	public String movedmac;
	public String backupVNF;
	public int isBackupVNF;
	public String fnec_param;
	

	public Message cast() throws Exception {

		if (this.type.equals(Message.COMMAND_GET_PERFLOW)) 
		{	return new GetPerflowMessage(this);	}
		if (this.type.equals(Message.RESPONSE_SYN))
		{ return new SynMessage(this); }
		if (this.type.equals(Message.COMMAND_MOVE_PERFLOW)) 
		{ return new MovePerflowMessage(this);}
		if (this.type.equals(Message.COMMAND_MOVE_MULTI_FLOW)) 
		{ return new MoveMultiflowMessage(this);}
		if (this.type.equals(Message.HB)) 
		{ return new HBMessage(this);	}
		if (this.type.equals(Message.RESPONSE_ERROR)) 
		{ return new ErrorMessage(this);	}
		if (this.type.equals(Message.RESPONSE_MOVE_PERFLOW_ACK)) 
		{ return new MoveFlowAckMessage(this);	}
		if (this.type.equals(Message.BACKUP_SET_ACK)) 
		{ return new Message(this);	}
		if(this.type.equals(Message.COPY_STATE_PERFLOW_VNF_ACK))
			return new CopyStatePerflowAck(this);
		return null;
	}
}

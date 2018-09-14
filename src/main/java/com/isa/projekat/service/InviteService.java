package com.isa.projekat.service;

import com.isa.projekat.model.Invite;

public interface InviteService {

	Invite save(Invite invite);
	
	Invite sendInvite(Long reservationId, Long userId);
	
	Invite acceptInvite(Long inviteId);
	
	Invite declineInvite(Long inviteId);
	
	Invite findOne(Long inviteId);
	
	void sendInviteEmail(Long userId, Long inviteId);
	
}

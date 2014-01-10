/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.contenttargeting.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.contenttargeting.service.http.UserSegmentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contenttargeting.service.http.UserSegmentServiceSoap
 * @generated
 */
public class UserSegmentSoap implements Serializable {
	public static UserSegmentSoap toSoapModel(UserSegment model) {
		UserSegmentSoap soapModel = new UserSegmentSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setUserSegmentId(model.getUserSegmentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static UserSegmentSoap[] toSoapModels(UserSegment[] models) {
		UserSegmentSoap[] soapModels = new UserSegmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserSegmentSoap[][] toSoapModels(UserSegment[][] models) {
		UserSegmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserSegmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserSegmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserSegmentSoap[] toSoapModels(List<UserSegment> models) {
		List<UserSegmentSoap> soapModels = new ArrayList<UserSegmentSoap>(models.size());

		for (UserSegment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserSegmentSoap[soapModels.size()]);
	}

	public UserSegmentSoap() {
	}

	public long getPrimaryKey() {
		return _userSegmentId;
	}

	public void setPrimaryKey(long pk) {
		setUserSegmentId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getUserSegmentId() {
		return _userSegmentId;
	}

	public void setUserSegmentId(long userSegmentId) {
		_userSegmentId = userSegmentId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private String _uuid;
	private long _userSegmentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
}
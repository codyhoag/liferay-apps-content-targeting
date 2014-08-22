/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.portal.contenttargeting.portlet.util;

import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.contenttargeting.model.Campaign;
import com.liferay.portal.contenttargeting.service.CampaignLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Locale;

import javax.portlet.PortletConfig;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Eudaldo Alonso
 */
public class CampaignQueryRule extends AssetQueryRule {

	public CampaignQueryRule(
			long assetEntryId, long campaignId, int index, Locale locale)
		throws PortalException, SystemException {

		super(assetEntryId, index, locale);

		_campaignId = campaignId;

		try {
			Bundle bundle = FrameworkUtil.getBundle(getClass());

			CampaignLocalService campaignLocalService =
				ServiceTrackerUtil.getService(
					CampaignLocalService.class, bundle.getBundleContext());

			_campaign = campaignLocalService.getCampaign(_campaignId);
		}
		catch (Exception e) {
		}
	}

	public long getCampaignId() {
		return _campaignId;
	}

	public String getCampaignName(Locale locale) {
		if (_campaign != null) {
			return _campaign.getName(locale);
		}

		return StringPool.BLANK;
	}

	public int getCampaignPriority() {
		if (_campaign != null) {
			return _campaign.getPriority();
		}

		return -1;
	}

	public String getSummary(PortletConfig portletConfig, Locale locale)
		throws SystemException {

		if (_campaignId == 0) {
			return LanguageUtil.get(portletConfig, locale, "default");
		}

		return getCampaignName(locale);
	}

	public boolean isValid() {
		if (!super.isValid()|| (_campaignId <= 0)) {
			return false;
		}

		return true;
	}

	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
	}

	private Campaign _campaign;
	private long _campaignId;

}
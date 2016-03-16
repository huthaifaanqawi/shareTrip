package edu.mum.shareTrip.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import edu.mum.shareTrip.domain.Authority;

public class AuthorityFormatter implements Formatter<Authority> {

	@Override
	public String print(Authority object, Locale locale) {
		return "ROLE_USER";
	}

	@Override
	public Authority parse(String text, Locale locale) throws ParseException {
		Authority authority = new Authority();
		authority.setAuthority(text);
		return authority;
	}

}

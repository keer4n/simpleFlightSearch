INSERT INTO flight (flight_number, aircraft, arrival, carrier, departure, destination, distance, origin, status, travel_time)
values  (2006, "Airbus A320", str_to_date("2018-01-31T07:57:00", "%Y-%c-%dT%T"), "UA", str_to_date("2018-01-31T05:10:00", "%Y-%c-%dT%T"), 
"ORD", 925, "IAH", "Arrived at Gate", "02:47"),
(2007, "Boeing 440", str_to_date("2018-01-31T07:57:00", "%Y-%c-%dT%T"), "UA", str_to_date("2018-01-31T05:10:00", "%Y-%c-%dT%T"), 
"DFW", 925, "ORD", "Arrived at Gate", "02:47"),
(2008, "Airbus A320", str_to_date("2018-01-31T07:57:00", "%Y-%c-%dT%T"), "UA", str_to_date("2018-01-31T05:10:00", "%Y-%c-%dT%T"), 
"LGX", 925, "ORD", "Arrived at Gate", "02:47"),
(2009, "Boeing 440", str_to_date("2018-01-15T07:57:00", "%Y-%c-%dT%T"), "UA", str_to_date("2018-01-15T05:10:00", "%Y-%c-%dT%T"), 
"LAX", 925, "NASH", "Arrived at Gate", "02:47"),
(2010, "Airbus A320", str_to_date("2018-01-15T07:57:00", "%Y-%c-%dT%T"), "UA", str_to_date("2018-01-15T05:10:00", "%Y-%c-%dT%T"), 
"ORD", 925, "DLL", "Arrived at Gate", "02:47");

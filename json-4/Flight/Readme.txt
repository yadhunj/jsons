Property name	Value	Description
kind	string	Identifies this as a QPX Express API search response resource. Value: the fixed string qpxExpress#tripsSearch.
trips	nested object	All possible solutions to the QPX Express search request.
trips.kind	string	Identifies this as a QPX Express trip response object, which consists of zero or more solutions. Value: the fixed string qpxexpress#tripOptions.
trips.requestId	string	An identifier uniquely identifying this response.
trips.data	nested object	Informational data global to list of solutions.
trips.data.kind	string	Identifies this as QPX Express response resource, including a trip's airport, city, taxes, airline, and aircraft. Value: the fixed string qpxexpress#data.
trips.data.airport[]	list	The airport of an origin or destination.
trips.data.airport[].kind	string	Identifies this as an airport object. Value: the fixed string qpxexpress#airportData.
trips.data.airport[].code	string	An airport's code. For example, for Boston Logan airport, this is BOS.
trips.data.airport[].city	string	The city code an airport is located in. For example, for JFK airport, this is NYC.
trips.data.airport[].name	string	The name of an airport. For example, for airport BOS the name is "Boston Logan International".
trips.data.city[]	list	The city that is either the origin or destination of part of a trip.
trips.data.city[].kind	string	Identifies this as a city, typically with one or more airports. Value: the fixed string qpxexpress#cityData.
trips.data.city[].code	string	The IATA character ID of a city. For example, for Boston this is BOS.
trips.data.city[].country	string	The two-character country code of the country the city is located in. For example, US for the United States of America.
trips.data.city[].name	string	The full name of a city. An example would be: New York.
trips.data.aircraft[]	list	The aircraft that is flying between an origin and destination.
trips.data.aircraft[].kind	string	Identifies this as an aircraftData object. Value: the fixed string qpxexpress#aircraftData
trips.data.aircraft[].code	string	The aircraft code. For example, for a Boeing 777 the code would be 777.
trips.data.aircraft[].name	string	The name of an aircraft, for example Boeing 777.
trips.data.tax[]	list	The taxes due for flying between an origin and a destination.
trips.data.tax[].kind	string	Identifies this as a tax data object, representing some tax. Value: the fixed string qpxexpress#taxData.
trips.data.tax[].id	string	An identifier uniquely identifying a tax in a response.
trips.data.tax[].name	string	The name of a tax.
trips.data.carrier[]	list	The airline carrier of the aircraft flying between an origin and destination. Allowed values are IATA carrier codes.
trips.data.carrier[].kind	string	Identifies this as a kind of carrier (for example, an airline, bus line, railroad, etc). Value: the fixed string qpxexpress#carrierData.
trips.data.carrier[].code	string	The IATA designator of a carrier (airline, etc). For example, for American Airlines, the code is AA.
trips.data.carrier[].name	string	The long, full name of a carrier. For example: American Airlines.
trips.tripOption[]	list	A list of priced itinerary solutions to the QPX Express query.
trips.tripOption[].kind	string	Identifies this as a trip information object. Value: the fixed string qpxexpress#tripOption.
trips.tripOption[].saleTotal	string	The total price for all passengers on the trip, in the form of a currency followed by an amount, e.g. USD253.35.
trips.tripOption[].id	string	Identifier uniquely identifying this trip in a response.
trips.tripOption[].slice[]	list	The slices that make up this trip's itinerary.
trips.tripOption[].slice[].kind	string	Identifies this as a slice object. A slice represents a traveller's intent, the portion of a low-fare search corresponding to a traveler's request to get between two points. One-way journeys are generally expressed using 1 slice, round-trips using 2. Value: the fixed string qpxexpress#sliceInfo.
trips.tripOption[].slice[].duration	integer	The duration of the slice in minutes.
trips.tripOption[].slice[].segment[]	list	The segment(s) constituting the slice.
trips.tripOption[].slice[].segment[].kind	string	Identifies this as a segment object. A segment is one or more consecutive legs on the same flight. For example a hypothetical flight ZZ001, from DFW to OGG, could have one segment with two legs: DFW to HNL (leg 1), HNL to OGG (leg 2). Value: the fixed string qpxexpress#segmentInfo.
trips.tripOption[].slice[].segment[].duration	integer	The duration of the flight segment in minutes.
trips.tripOption[].slice[].segment[].flight	nested object	The flight this is a segment of.
trips.tripOption[].slice[].segment[].flight.carrier	string	The 2-letter IATA airline designator for the segment.
trips.tripOption[].slice[].segment[].flight.number	string	The flight number.
trips.tripOption[].slice[].segment[].id	string	An ID uniquely identifying the segment in the solution.
trips.tripOption[].slice[].segment[].cabin	string	The cabin booked for this segment.
trips.tripOption[].slice[].segment[].bookingCode	string	The booking code or class for this segment.
trips.tripOption[].slice[].segment[].bookingCodeCount	integer	The number of seats available in this booking code on this segment.
trips.tripOption[].slice[].segment[].marriedSegmentGroup	string	The solution-based index of a segment in a married segment group. Married segments can only be booked together. For example, an airline might report a certain booking code as sold out from Boston to Pittsburgh, but as available as part of two married segments Boston to Chicago connecting through Pittsburgh. For example content of this field, consider the round-trip flight ZZ1 PHX-PHL ZZ2 PHL-CLT ZZ3 CLT-PHX. This has three segments, with the two outbound ones (ZZ1 ZZ2) married. In this case, the two outbound segments belong to married segment group 0, and the return segment belongs to married segment group 1.
trips.tripOption[].slice[].segment[].subjectToGovernmentApproval	boolean	Whether the operation of this segment remains subject to government approval.
trips.tripOption[].slice[].segment[].leg[]	list	The legs composing this segment.
trips.tripOption[].slice[].segment[].leg[].kind	string	Identifies this as a leg object. A leg is the smallest unit of travel, in the case of a flight a takeoff immediately followed by a landing at two set points on a particular carrier with a particular flight number. Value: the fixed string qpxexpress#legInfo.
trips.tripOption[].slice[].segment[].leg[].id	string	An identifier that uniquely identifies this leg in the solution.
trips.tripOption[].slice[].segment[].leg[].aircraft	string	The aircraft (or bus, ferry, railcar, etc) travelling between the two points of this leg.
trips.tripOption[].slice[].segment[].leg[].arrivalTime	string	The scheduled time of arrival at the destination of the leg, local to the point of arrival.
trips.tripOption[].slice[].segment[].leg[].departureTime	string	The scheduled departure time of the leg, local to the point of departure.
trips.tripOption[].slice[].segment[].leg[].origin	string	The leg origin as a city and airport.
trips.tripOption[].slice[].segment[].leg[].destination	string	The leg destination as a city and airport.
trips.tripOption[].slice[].segment[].leg[].originTerminal	string	The terminal the flight is scheduled to depart from.
trips.tripOption[].slice[].segment[].leg[].destinationTerminal	string	The terminal the flight is scheduled to arrive at.
trips.tripOption[].slice[].segment[].leg[].duration	integer	The scheduled travelling time from the origin to the destination.
trips.tripOption[].slice[].segment[].leg[].operatingDisclosure	string	Department of Transportation disclosure information on the actual operator of a flight in a code share. (A code share refers to a marketing agreement between two carriers, where one carrier will list in its schedules (and take bookings for) flights that are actually operated by another carrier.)
trips.tripOption[].slice[].segment[].leg[].onTimePerformance	integer	In percent, the published on time performance on this leg.
trips.tripOption[].slice[].segment[].leg[].mileage	integer	The number of miles in this leg.
trips.tripOption[].slice[].segment[].leg[].meal	string	A simple, general description of the meal(s) served on the flight, for example: "Hot meal".
trips.tripOption[].slice[].segment[].leg[].secure	boolean	Whether passenger information must be furnished to the United States Transportation Security Administration (TSA) prior to departure.
trips.tripOption[].slice[].segment[].leg[].connectionDuration	integer	Duration of a connection following this leg, in minutes.
trips.tripOption[].slice[].segment[].leg[].changePlane	boolean	Whether the passenger(s) have to change planes following this leg. Only applies to the next leg.
trips.tripOption[].slice[].segment[].connectionDuration	integer	In minutes, the duration of the connection following this segment.
trips.tripOption[].pricing[]	list	Per passenger pricing information.
trips.tripOption[].pricing[].kind	string	Identifies this as a pricing object, representing the price of one or more travel segments. Value: the fixed string qpxexpress#pricingInfo.
trips.tripOption[].pricing[].fare[]	list	The fare used to price one or more segments.
trips.tripOption[].pricing[].fare[].kind	string	Identifies this as a fare object. Value: the fixed string qpxexpress#fareInfo.
trips.tripOption[].pricing[].fare[].id	string	A unique identifier of the fare.
trips.tripOption[].pricing[].fare[].carrier	string	The 2-letter IATA airline designator of the carrier whose fare this is.
trips.tripOption[].pricing[].fare[].origin	string	The origin city to which this fare applies
trips.tripOption[].pricing[].fare[].destination	string	The destination city to which this fare applies
trips.tripOption[].pricing[].fare[].basisCode	string	The Fare Basis Code.
trips.tripOption[].pricing[].fare[].private	boolean	Whether this is a private fare, for example one offered only to select customers rather than the general public.
trips.tripOption[].pricing[].segmentPricing[]	list	The per-segment price and baggage information.
trips.tripOption[].pricing[].segmentPricing[].kind	string	Identifies this as a segment pricing object, representing the price of this segment. Value: the fixed string qpxexpress#segmentPricing.
trips.tripOption[].pricing[].segmentPricing[].fareId	string	A segment identifier unique within a single solution. It is used to refer to different parts of the same solution.
trips.tripOption[].pricing[].segmentPricing[].segmentId	string	Unique identifier in the response of this segment.
trips.tripOption[].pricing[].segmentPricing[].freeBaggageOption[]	list	Details of the free baggage allowance on this segment.
trips.tripOption[].pricing[].segmentPricing[].freeBaggageOption[].kind	string	Identifies this as free baggage object, allowed on one segment of a trip. Value: the fixed string qpxexpress#freeBaggageAllowance.
trips.tripOption[].pricing[].segmentPricing[].freeBaggageOption[].bagDescriptor[]	list	A representation of a type of bag, such as an ATPCo subcode, Commercial Name, or other description.
trips.tripOption[].pricing[].segmentPricing[].freeBaggageOption[].bagDescriptor[].kind	string	Identifies this as a baggage object. Value: the fixed string qpxexpress#bagDescriptor.
trips.tripOption[].pricing[].segmentPricing[].freeBaggageOption[].bagDescriptor[].commercialName	string	Provides the commercial name for an optional service.
trips.tripOption[].pricing[].segmentPricing[].freeBaggageOption[].bagDescriptor[].count	integer	How many of this type of bag will be checked on this flight.
trips.tripOption[].pricing[].segmentPricing[].freeBaggageOption[].bagDescriptor[].description[]	list	A description of the baggage.
trips.tripOption[].pricing[].segmentPricing[].freeBaggageOption[].bagDescriptor[].subcode	string	The standard IATA subcode used to identify this optional service.
trips.tripOption[].pricing[].segmentPricing[].freeBaggageOption[].kilos	integer	The maximum number of kilos all the free baggage together may weigh.
trips.tripOption[].pricing[].segmentPricing[].freeBaggageOption[].kilosPerPiece	integer	The maximum number of kilos any one piece of baggage may weigh.
trips.tripOption[].pricing[].segmentPricing[].freeBaggageOption[].pieces	integer	The number of free pieces of baggage allowed.
trips.tripOption[].pricing[].segmentPricing[].freeBaggageOption[].pounds	integer	The number of pounds of free baggage allowed.
trips.tripOption[].pricing[].baseFareTotal	string	The total fare in the base fare currency (the currency of the country of origin). This element is only present when the sales currency and the currency of the country of commencement are different.
trips.tripOption[].pricing[].saleFareTotal	string	The total fare in the sale or equivalent currency.
trips.tripOption[].pricing[].saleTaxTotal	string	The taxes in the sale or equivalent currency.
trips.tripOption[].pricing[].saleTotal	string	Total per-passenger price (fare and tax) in the sale or equivalent currency.
trips.tripOption[].pricing[].passengers	nested object	The number of passengers to which this price applies.
trips.tripOption[].pricing[].passengers.kind	string	Identifies this as a passenger count object, representing the number of passengers. Value: the fixed string qpxexpress#passengerCounts.
trips.tripOption[].pricing[].passengers.adultCount	integer	The number of passengers that are adults.
trips.tripOption[].pricing[].passengers.childCount	integer	The number of passengers that are children.
trips.tripOption[].pricing[].passengers.infantInLapCount	integer	The number of passengers that are infants travelling in the lap of an adult.
trips.tripOption[].pricing[].passengers.infantInSeatCount	integer	The number of passengers that are infants each assigned a seat.
trips.tripOption[].pricing[].passengers.seniorCount	integer	The number of passengers that are senior citizens.
trips.tripOption[].pricing[].tax[]	list	The taxes used to calculate the tax total per ticket.
trips.tripOption[].pricing[].tax[].kind	string	Identifies this as a tax information object. Value: the fixed string qpxexpress#taxInfo.
trips.tripOption[].pricing[].tax[].id	string	Identifier uniquely identifying this tax in a response. Not present for unnamed carrier surcharges.
trips.tripOption[].pricing[].tax[].chargeType	string	Whether this is a government charge or a carrier surcharge.
trips.tripOption[].pricing[].tax[].code	string	The code to enter in the ticket's tax box.
trips.tripOption[].pricing[].tax[].country	string	For government charges, the country levying the charge.
trips.tripOption[].pricing[].tax[].salePrice	string	The price of the tax in the sales or equivalent currency.
trips.tripOption[].pricing[].fareCalculation	string	The horizontal fare calculation. This is a field on a ticket that displays all of the relevant items that go into the calculation of the fare.
trips.tripOption[].pricing[].latestTicketingTime	string	The latest ticketing time for this pricing assuming the reservation occurs at ticketing time and there is no change in fares/rules. The time is local to the point of sale (POS).
trips.tripOption[].pricing[].ptc	string	The passenger type code for this pricing. An alphanumeric code used by a carrier to restrict fares to certain categories of passenger. For instance, a fare might be valid only for senior citizens.
trips.tripOption[].pricing[].refundable	boolean	Whether the fares on this pricing are refundable.










	


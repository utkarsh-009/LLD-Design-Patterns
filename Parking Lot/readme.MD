# Parking Lot Design

## Overview

1. Vehicle arrives at an entry gate.
   - The parking lot can have multiple entry gates.

2. Based on vehicle type, a particular parking spot is selected.
   - The parking strategy can be flexible:
     - random
     - specific strategy
   - The parking lot can have multiple levels.
   - Concurrency should be handled properly:
     - the same parking spot cannot be reserved by two different vehicles
     - for one vehicle type (e.g. two wheeler), the whole parking lot should not be blocked

3. If a parking spot is available, a ticket is generated for the vehicle.
   - Ticket fields:
     - vehicle number
     - parking level number
     - parking spot number
     - entry time

4. At the exit gate, cost computation is done.
   - Cost strategies may include:
     - fixed price
     - hourly based computation

5. Payment is made against the ticket at the exit gate and the parking spot is freed again.
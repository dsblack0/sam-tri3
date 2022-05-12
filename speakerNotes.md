{% include navigation.html %}

# Speaker: Medha Parlikar

- Cheif Technology Officer of Casper Labs

# Blockchains
- has become of the most important skills in technological field
     - extremely important in the job field
     - gives flexibility
- block = memory of a set of transactions made in the past
    - tip = top of the blockchain = where you find your most recent transaction
- Bitcoin blockchain = references a copy of a UXTO ledger that only maintains balances - keeps track of bitcoin
- VM Based Blockchain (Ethereum) = references state of a virtual machine - keep track of the outcomes of a program executing

## Bitcoin
- US has been printing a lot of paper money so the value of money has been decreases
     - Bicoin = hard money (algorithmic form)
- 2009 - bitcoin started, blockchain began before this
- crypto curreny uses blockchain

## P2P Network
- communicate over protocol
- Mesh network has no central server
- blockchains have p2p networks secured by hashing
     - get cryptographic keys that the blockchain hasn't been tampered with
     - goes from parent block


## Consensus Protocol
- way that p2p networks agree on a set of actions
     - in p2p networks, have no guarantees that the messages are recieved
     - nodes agree set of messages through a protocol to agree that a block is good (met certain criterias)
- For protocol to be solid, it must be:
     - decentralized = no central server
     - permissionless = anyone can run it or shut it off when they want
     - safe = guarantee that once a transaction is in a block, it stays there
     - live = blockchain continues to add blocks
     - secure = results from other characteristics
- can safely send bitcoin across the world quickly

### Esential Node Architecture
- all the nodes are the exact same size
- consensus protocol runs on top
- Global State Trie = internal representation of the blockchain
     - a special database
- Server APIs & Client APIs recieve transactions
     - transactions queued up when first recieved

### Types of Consensus Protocols
- Proof of Work Hashing
     - security through work
     - slow, expensive, wasteful
     - strongly "synchronous"
     - permissionless
     - requires special hardware
     - Used by: BTC, LTC, BSV, ETH, ETC
- Proof of State Bonding
     - security through bonds
     - fast, efficient
     - synchronous, partially synchronous, or fully asynchronous
     - Used by: CASPER

## Keys and Accounts
- public keys = what is on the blockchain
     - use it to have crypto send to
- private keys = what you see privately
     - you use it to send your crypto - transactions are signed with it
     - on crypto wallet

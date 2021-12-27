'''
Título del proyecto: Mi criptomoneda con Python
Autor: Lucas
'''

import hashlib
import datetime
import json
import pprint
from time import time


# ------------------------- BLOQUES -------------------------------------
class Block:

    # Constructor
    def __init__(self, timeStamp, trans, previousBlock = ''):
        self.timeStamp = timeStamp
        self.trans = trans
        self.previousBlock = previousBlock
        self.difficultyIncrement = 0
        self.hash = self.calculateHash(trans, timeStamp, self.difficultyIncrement) #Le doy el self porque no lo he pasado por parámetro

    # Función para calcular el Hash
    def calculateHash(self, data, timeStamp, difficultyIncrement):
        data = str(data) + str(timeStamp) + str(difficultyIncrement)
        data = data.encode()
        hash = hashlib.sha256(data)
        return hash.hexdigest()

    # Función para realizar el minado de bloques
    def mineBlock(self, difficulty):
        # Hash: 0000...083jbjc89
        difficultyCheck = "0" * difficulty

        while self.hash[:difficulty] != difficultyCheck:
            self.hash = self.calculateHash(self.trans, self.timeStamp, self.difficultyIncrement)
            self.difficultyIncrement += 1
# ------------------------- CADENA DE BLOQUES -------------------------------------

class Blockchain:
    # Constructor
    def __init__(self):
        self.chain = [self.GenesisBlock()]
        self.difficulty = 5
        self.pendingTransaction = []
        self.reward = 10

    def GenesisBlock(self):
        genesisBlock = Block(str(datetime.datetime.now()), "Soy el bloque cero de la cadena ")
        return genesisBlock

    def getLastBlock(self):
        return self.chain[len(self.chain) - 1]

    def minePendingTrans(self, minerRewardAddress):
        newBlock = Block(str(datetime.datetime.now()), self.pendingTransaction)
        newBlock.mineBlock(self.difficulty)
        newBlock.previousBlock = self.getLastBlock().hash

        print(f"Hash del bloque previo: {newBlock.previousBlock}")

        testChain = []
        for trans in newBlock.trans:
            temp = json.dumps(trans.__dict__, indent=5, separators=(',',':'))
            testChain.append(temp)
        pprint.pprint(testChain)

        self.chain.append(newBlock)
        print(f"Hash del bloque: {newBlock.hash}")
        print("Nuevo bloque añadido!!!")

        rewardTrans = Transaction("Sistema", minerRewardAddress, self.reward)
        self.pendingTransaction.append(rewardTrans)
        self.pendingTransaction = []


    def isChainValid(self):
        for x in range(1, len(self.chain)):
            currentBlock=self.chain[x]
            previousBlock=self.chain[x-1]

            if(currentBlock.previousBlock != previousBlock.hash):
                print("La cadena no es válida!")

        print("La cadena es válida y segura!")

    def createTrans(self, transaction):
        self.pendingTransaction.append(transaction)

    def getBalance(self, walletAddress):
        balance=0
        for block in self.chain:
            if block.previousBlock == "":
                continue
            for transaction in block.trans:
                if transaction.fromWallet == walletAddress:
                    balance -= transaction.amount
                if transaction.toWallet == walletAddress:
                    balance += transaction.amount
        return balance
# ----------------------------TRANSACTION------------------------------
class Transaction:
    def __init__(self, fromWallet, toWallet, amount):
        self.fromWallet = fromWallet
        self.toWallet = toWallet
        self.amount = amount

# --------------------------------------------------------------------------------
# --------------------------------------------------------------------------------
# ----------------------------ZONA DE TESTING-------------------------------------
# --------------------------------------------------------------------------------
# --------------------------------------------------------------------------------

mi_crypto = Blockchain()

print("LucasBahamondes empezó a minar...")

mi_crypto.createTrans(Transaction("Gonzalo", "Dexter", 0.01))
mi_crypto.createTrans(Transaction("Amaro", "Damian", 200))
mi_crypto.createTrans(Transaction("Lorena", "Elena", 0.6))

tiempo_inicial = time()
mi_crypto.minePendingTrans("LucasBahamondes")
tiempo_final = time()
print(f"LucasBahamondes tardó: {tiempo_final-tiempo_inicial} secs")

print('-'*20)

print("LucasBahamondes empezó a minar...")

mi_crypto.createTrans(Transaction("Alberto", "Abel", 45.5))
mi_crypto.createTrans(Transaction("Saria", "Petrova", 120))
mi_crypto.createTrans(Transaction("Laurencio", "Pablo", 50))

tiempo_inicial = time()
mi_crypto.minePendingTrans("AmaroBahamondes")
tiempo_final = time()
print(f"AmaroBahamondes tardó: {tiempo_final-tiempo_inicial} secs")

print('-'*20)
print(f"LucasBahamondes tiene " + str(mi_crypto.getBalance("LucasBahamondes"))+"LucasCoins en su Wallet")
print(f"AmaroBahamondes tiene " + str(mi_crypto.getBalance("AmaroBahamondes"))+"LucasCoins en su Wallet")
print('-'*20)

#Hash de los bloques de la cadena

for x in range(len(mi_crypto.chain)):
    print(f"Hash del Bloque {x}: {mi_crypto.chain[x].hash}")

print(mi_crypto.isChainValid())







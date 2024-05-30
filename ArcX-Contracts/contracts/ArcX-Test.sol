// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

import "@openzeppelin/contracts/token/ERC20/ERC20.sol";
import "@openzeppelin/contracts/access/Ownable.sol";

contract ArcxAxcTest is ERC20, Ownable(msg.sender) {
    uint256 public constant AUTO_MINT_THRESHOLD = 9000000 * (10 ** 18);
    uint256 public constant MINT_AMOUNT = 100000000 * (10 ** 18);

    constructor() ERC20("ARCX AXC TEST", "AXC") {
        _mint(msg.sender, 100000000 * (10 ** uint256(decimals())));
    }

    function mint(address to, uint256 amount) public onlyOwner {
        _mint(to, amount);
    }
    
    function transferAndUse(address recipient, uint256 amount) external onlyOwner {
        require(balanceOf(msg.sender) >= amount, "Insufficient balance");

        _transfer(msg.sender, recipient, amount * (10 ** 18));

        if (balanceOf(msg.sender) < AUTO_MINT_THRESHOLD) {
            _mint(msg.sender, MINT_AMOUNT);
        }
    }
}
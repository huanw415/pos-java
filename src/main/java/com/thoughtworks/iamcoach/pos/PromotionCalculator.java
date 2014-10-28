package com.thoughtworks.iamcoach.pos;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public abstract class PromotionCalculator {

    public abstract double calculatePromotion(CartItem cartItem);

}

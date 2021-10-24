//
//  SecondViewController.m
//  2Zadanie
//
//  Created by student on 19/10/2021.
//  Copyright © 2021 aplikacja. All rights reserved.
//

#import "SecondViewController.h"

@interface SecondViewController ()

@end

@implementation SecondViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    _modifiedSurnameTextField.text = self.surname;
}

- (IBAction) enter {

    NSString *itemToPassBack = self.modifiedSurnameTextField.text;
    [self.delegate addItemViewController:self didFinishEnteringItem:itemToPassBack];
    [self dismissViewControllerAnimated:YES completion:nil];
    
}


@end

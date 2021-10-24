//
//  ViewController.m
//  2Zadanie
//
//  Created by student on 19/10/2021.
//  Copyright © 2021 aplikacja. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

- (IBAction) enter {
    NSString *yourName = self.inputField.text;
    NSString *myName = @"Bartosz";
    NSString *message;
    
    if([yourName length] == 0){
        yourName = @"World";
    }
    if ([yourName isEqualToString:myName]){
        message = [NSString stringWithFormat: @"Hello %@. We have teh same name :)", yourName];
    } else {
        message = [NSString stringWithFormat:@"Hello %@!", yourName];
    }
    
    self.messageLabel.text = message;
}

-(void) prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    if([segue.identifier isEqualToString:@"sendSurnameSegue"]){
        SecondViewController *controller = (SecondViewController *) segue.destinationViewController;
        controller.surname = self.inputFieldSecond.text;
        controller.delegate = self;
    }
}

-(void) addItemViewController:(SecondViewController *)controller didFinishEnteringItem:(NSString *)item{
    NSLog(@"This was returned from SecondViewController %@", item);
    self.inputFieldSecond.text = item;
}

@end

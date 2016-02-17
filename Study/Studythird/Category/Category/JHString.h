//
//  JHString.h
//  Category
//
//  Created by 박종훈 on 2016. 2. 9..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface JHString : NSString

-(NSString*) jhString;

- (JHString *)uppercaseString;
- (NSArray<JHString *> *)componentsSeparatedByString:(NSString *)separator;
@end
